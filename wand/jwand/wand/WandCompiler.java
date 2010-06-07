package wand;

import wand.generators.GeneratorFactory;
import wand.parser.*;

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
        if ( outputFile == null ) {
            assert sourceFile.endsWith( ".wand" ): "Could not guess filename without a .wand extension, " +
                                                   "please provide a .wand file or use -o <filename> to " +
                                                   "specify the output filename";
            
            outputFile = sourceFile.substring( 0, sourceFile.length()-5 ) + ".c";
            
            // make sure we don't overwrite the input file
        }
        
        assert !sourceFile.equals(outputFile): "Source and destination file are the same file!";
        
        //System.out.println( sourceFile + " -> " + outputFile );
        compileProgram( sourceFile, outputFile );
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
		
		wand.visitors.VariableMapper vmap = new wand.visitors.VariableMapper( );
		vmap.visitFrom( program, null );
		
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
	
	
	
	
	// from: http://java.sun.com/j2se/1.4.2/docs/guide/lang/assert.html
    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled)
            throw new RuntimeException("Asserts must be enabled. Please run with -ea");
    }
}