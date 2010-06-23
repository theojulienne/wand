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
        
        String[] otherArgs = parser.getRemainingArgs();
        
        assert otherArgs.length == 1: "Must currently specify exactly one source file";
        
        String sourceFile = otherArgs[0];
        String outputFile = (String)parser.getOptionValue( outputFilename );
        
        assert sourceFile.endsWith( ".wand" ): "Could not guess filename without a .wand extension, " +
                                               "please provide a .wand file or use -o <filename> to " +
                                               "specify the output filename";
        String baseFilename = sourceFile.substring( 0, sourceFile.length()-5 );
        
        if ( outputFile == null ) {
            outputFile = baseFilename + ".c";
            
            // make sure we don't overwrite the input file
        }
        
        assert !sourceFile.equals(outputFile): "Source and destination file are the same file!";
        assert !sourceFile.equals(baseFilename): "Source and destination file are the same file!";
        
        //System.out.println( sourceFile + " -> " + outputFile );
        compileProgram( sourceFile, outputFile );
        
        Boolean shouldCompileOnly = (Boolean)parser.getOptionValue( compileOnly );
        
        if ( shouldCompileOnly == null || !shouldCompileOnly ) {
            System.out.println( "Compiling and linking with gcc.." );
            gccCompileProgram( outputFile, baseFilename );
        }
	}
	
	private static void compileProgram( String sourceFile, String outputFile ) {
	    FileInputStream input = null;
	    FileOutputStream output = null;
	    
	    try {
	        input = new FileInputStream( sourceFile );
	        output = new FileOutputStream( outputFile );
	    } catch ( FileNotFoundException e ) {
	        System.out.println( "File not found: " + e.getMessage( ) );
	        System.exit( 1 );
	    }
	    
	    assert input != null && output != null;
	    
	    WandParser parser = new WandParser( input );
		ASTProgram program = null;
		
		try {
		    program = parser.Program( );
		} catch (ParseException e) {
		    System.out.println( e.getMessage() );
		    e.printStackTrace( );
		    System.exit( 1 );
		}
		
		WandVisitor[] visitors = {
		    /**** Parse tree modifications ****/
		    
		    // Expand infix expressions (a op b op c) -> ((a op b) op c)
		    new wand.visitors.InfixExpansion( ),
		    // Merge function modifiers into FunctionDeclaration nodes
		    new wand.visitors.FunctionModifiers( ),
		    
		    /**** Compilation passes ****/
		    
		    // Load all C header imports
		    //new wand.visitors.ImportCHeaders( ),
		    // Find all declared types (classes etc) and register them
		    new wand.visitors.TypeFinder( ),
		    // Find all uses of types and map them to registered types
		    new wand.visitors.TypeMapper( ),
		    // Find all uses of variables and map them to scope'd declarations
		    new wand.visitors.VariableMapper( ),
		};
		
		for ( int i = 0; i < visitors.length; i++ ) {
		    visitors[i].visitFrom( program, null );
		}
		
		wand.backends.c.CCodeGenerator codegen = new wand.backends.c.CCodeGenerator( );
		codegen.setOutputStream( output );
		codegen.generate( program );
		
		try {
		    input.close( );
		    output.close( );
		} catch ( IOException e ) {
		    System.out.println( "Error writing file: " + e.getMessage( ) );
	        System.exit( 1 );
		}
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