package wand;

import wand.generators.GeneratorFactory;
import wand.parser.*;
import wand.core.WandVisitor;

import jargs.gnu.CmdLineParser;

import java.io.*;

public class WandCompiler {
	public static void main( String[] args ) {
	    CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option outputFilename = parser.addStringOption( 'o', "output" );
        CmdLineParser.Option compileOnly = parser.addBooleanOption( 'c', "compile" );
        CmdLineParser.Option verbose = parser.addBooleanOption( 'v', "verbose" );

        try {
            parser.parse(args);
        } catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        
        String[] sourceFiles = parser.getRemainingArgs();
        
        assert sourceFiles.length >= 1: "You must specify at least 1 source file to compile";
        
        String outputExec = (String)parser.getOptionValue( outputFilename );
        
        Boolean shouldCompileOnlyObj = (Boolean)parser.getOptionValue( compileOnly );
        boolean shouldCompileOnly = ( shouldCompileOnlyObj != null && shouldCompileOnlyObj );
        
        // we're linking, and no output file was specified
        if ( !shouldCompileOnly && outputExec == null ) {
            assert sourceFiles.length == 1: "You must specify an output file with -o <filename> when " +
                                            "compiling more than one source file";
            
            String sourceFile = sourceFiles[0];
            
            assert sourceFile.endsWith( ".wand" ): "Could not guess filename without a .wand extension, " +
                                                   "please provide a .wand file or use -o <filename> to " +
                                                   "specify the output filename";
            String baseFilename = sourceFile.substring( 0, sourceFile.length()-5 );
            
            outputExec = baseFilename;
            
            // make sure we don't overwrite the input file
            assert !sourceFile.equals(outputExec): "Source and destination file are the same file!";
            assert !sourceFile.equals(baseFilename): "Source and destination file are the same file!";
        }
        
        // accident safety
        for ( int i = 0; i < sourceFiles.length; i++ ) {
            assert !sourceFiles[i].equals(outputExec): "Output file would overwrite a source file!";
        }
        
        System.out.println( sourceFiles + " -> " + outputExec );
        String[] outputFiles = compileWandSources( sourceFiles );
        
        if ( !shouldCompileOnly ) {
            assert outputExec.endsWith(".wand"): "Output file should not end with a .wand extension!";
            System.out.println( "Compiling and linking with gcc.." );
            //gccCompileProgram( outputFile, baseFilename );
            assert false: "wand gcc support temporarily disabled";
        }
	}
	
	private static String getCompiledFilename( String sourceFile ) {
	    assert sourceFile.endsWith( ".wand" ): "Source files should end with a .wand extension";
	    
	    String baseFilename = sourceFile.substring( 0, sourceFile.length()-5 );
	    
	    return baseFilename + ".c";
	}
	
	private static String[] compileWandSources( String[] sourceFiles ) {
	    String[] outputFilenames = new String[sourceFiles.length];
	    
	    // generate the filenames
	    for ( int i = 0; i < sourceFiles.length; i++ ) {
	        outputFilenames[i] = getCompiledFilename( sourceFiles[i] );
	    }
	    
	    // parse the source files
	    ASTProgram[] programs = new ASTProgram[sourceFiles.length];
	    for ( int i = 0; i < sourceFiles.length; i++ ) {
	        FileInputStream input = null;
	        String sourceFile = sourceFiles[i];
	        
	        try {
    	        input = new FileInputStream( sourceFile );
    	    } catch ( FileNotFoundException e ) {
    	        System.out.println( "File not found: " + e.getMessage( ) );
    	        System.exit( 1 );
    	    }
	        
	        assert input != null: "Could not open file: " + sourceFile;
	        
	        WandParser parser = new WandParser( input );
	        
	        try {
    		    programs[i] = parser.Program( );
    		} catch (ParseException e) {
    		    System.out.println( e.getMessage() );
    		    e.printStackTrace( );
    		    System.exit( 1 );
    		}
    		
    		assert programs[i] != null;
    		
    		try {
    		    input.close( );
    		} catch ( IOException e ) {
    		    System.out.println( "Error closing input file: " + e.getMessage( ) );
    	        System.exit( 1 );
    		}
	    }
	    
	    // run the visitors
	    Class[] visitorClasses = {
		    /**** Parse tree modifications ****/
		    
		    // Expand infix expressions (a op b op c) -> ((a op b) op c)
		    wand.visitors.InfixExpansion.class,
		    // Merge function modifiers into FunctionDeclaration nodes
		    wand.visitors.FunctionModifiers.class,
		    
		    /**** Compilation passes ****/
		    
		    // Load all C header imports
		    //wand.visitors.ImportCHeaders.class,
		    // Find namespace declarations and create the respective namespaces
		    wand.visitors.NamespaceFinder.class,
		    // Find all namespace imports (using statements) and match them up to namespaces
		    wand.visitors.NamespaceMapper.class,
		    // Find all declared types (classes etc) and register them in our namespace
		    wand.visitors.TypeFinder.class,
		    // Find all uses of types and map them to registered types
		    wand.visitors.TypeMapper.class,
		    // Find all uses of variables and map them to scope'd declarations
		    wand.visitors.VariableMapper.class,
		};
		
		for ( int v = 0; v < visitorClasses.length; v++ ) {
		    Class visitorClass = visitorClasses[v];
		    
		    for ( int i = 0; i < programs.length; i++ ) {
    		    try {
    		        WandVisitor visitor = (WandVisitor)visitorClass.newInstance( );
    		        visitor.visitFrom( programs[i], null );
    		    } catch ( InstantiationException e ) {
    		        e.printStackTrace( );
    		        assert false: "InstantiationException while creating a visitor instance";
    		    } catch ( IllegalAccessException e ) {
    		        e.printStackTrace( );
    		        assert false: "IllegalAccessException while creating a visitor instance";
    		    }
    		}
		}
	    
	    // generate the output
	    for ( int i = 0; i < sourceFiles.length; i++ ) {
	        FileOutputStream output = null;
	        String outputFile = outputFilenames[i];
	        
	        try {
    	        output = new FileOutputStream( outputFile );
    	    } catch ( FileNotFoundException e ) {
    	        System.out.println( "Could not create output file: " + e.getMessage( ) );
    	        System.exit( 1 );
    	    }
    	    
    	    assert output != null;
	        
	        wand.backends.c.CCodeGenerator codegen = new wand.backends.c.CCodeGenerator( );
    		codegen.setOutputStream( output );
    		codegen.generate( programs[i] );

    		try {
    		    output.close( );
    		} catch ( IOException e ) {
    		    System.out.println( "Error writing file: " + e.getMessage( ) );
    	        System.exit( 1 );
    		}
        }
		
		return outputFilenames;
	}
	
	private static void gccCompileProgram( String sourceFile, String outputBinary ) {
	    String s;
	    
	    try {
    	    Process p = Runtime.getRuntime().exec( "gcc " + sourceFile + " -o " + outputBinary );
    	    p.waitFor( );
	    
    	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch ( IOException e ) {
            System.out.println( "Error compiling with GCC: " + e.getMessage( ) );
	        System.exit( 1 );
        } catch ( InterruptedException e ) {
            System.out.println( "Error compiling with GCC: " + e.getMessage( ) );
	        System.exit( 1 );
        }
	}
	
	
	
	
	// from: http://java.sun.com/j2se/1.4.2/docs/guide/lang/assert.html
    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled)
            throw new RuntimeException("Asserts must be enabled. Please run with -ea");
    }
}