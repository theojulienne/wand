package wand.backends.c;

import java.io.*;

import wand.core.*;
import wand.parser.*;

public class CCodeGenerator extends WandVisitor {
    private PrintStream out;
    
    public void setOutputStream( PrintStream out ) {
        this.out = out;
    }
    
    public void generate( ASTProgram program ) {
        program.jjtAccept( this, null );
    }
    
    public Object visit(ASTBlock node, Object data) {
        writeBlockStart( );
        visitChildren(node, data);
        writeBlockEnd( );
        
        return data;
    }
    
    public Object visit(ASTLocalVariableDeclarationStatement node, Object data) {
        writeNewline( "// declare type: " + node.getType() );
        writeNewline( "// declare names: " );
        
        int numVars = node.getNumVariables( );
        for ( int i = 0; i < numVars; i++ ) {
            WandNode child = node.getVariable( i );
            
            writeNewline( "//     " + child );
            child.accept( this, data );
        }
        
        return data;
    }
    
    public Object visit(ASTVariableDeclarator node, Object data) {
        WandVariable identifier = (WandVariable)node.getIdentifier( );
        //writeString( "" + identifier.getIdentifier( ) + "" );
        this.visit( identifier, data );
        
        WandNode initializer = node.getInitializer( );
        if ( initializer != null ) {
            writeString( " = " );
            initializer.accept( this, data );
        }
        
        writeNewline( ";" );
        
        return data;
    }
    
    public Object visit(ASTInfixExpression node, Object data) {
        ASTExpression lhs = (ASTExpression)node.getLHS( );
        ASTExpression rhs = (ASTExpression)node.getRHS( );
        ASTInfixOperator op = (ASTInfixOperator)node.getOperator( );
        
        writeString( "( " );
        lhs.accept( this, data );
        writeString( " " );
        op.accept( this, data );
        writeString( " " );
        rhs.accept( this, data );
        writeString( " )" );
        
        return data;
    }
    
    public Object visit(ASTExpressionStatement node, Object data) {
        visitChildren(node, data);
        writeNewline( ";" );
        
        return data;
    }
    
    public Object visit(ASTIdentifier node, Object data) {
        WandVariable identifier = (WandVariable)node;
        
        writeString( identifier.getIdentifier( ) );
        
        return data;
    }
    
    public Object visit(ASTAssignExpression node, Object data) {
        ASTIdentifier lhs = (ASTIdentifier)node.getTarget( );
        ASTExpression rhs = (ASTExpression)node.getValueExpression( );
        ASTAssignOperator op = (ASTAssignOperator)node.getOperator( );
        
        lhs.accept( this, data );
        writeString( " " );
        op.accept( this, data );
        writeString( " " );
        rhs.accept( this, data );
        
        return data;
    }
    
    public Object visit(ASTIntegerLiteral node, Object data) {
        out.print( node.getInteger( ) );
        return data;
    }
    
    public Object visit(ASTInfixOperator node, Object data) {
        int operatorType = node.getOperatorType( );
        
        switch ( operatorType ) {
            case WandParserConstants.OP_MUL:
                writeString( "*" );
                break;
            case WandParserConstants.OP_DIV:
                writeString( "/" );
                break;
            case WandParserConstants.OP_MOD:
                writeString( "%" );
                break;
            case WandParserConstants.OP_ADD:
                writeString( "+" );
                break;
            case WandParserConstants.OP_SUB:
                writeString( "-" );
                break;
            default:
                assert false: "Unknown operator: " + WandParserConstants.tokenImage[operatorType];
        }
        
        return data;
    }
    
    public Object visit(ASTAssignOperator node, Object data) {
        int operatorType = node.getOperatorType( );
        
        switch ( operatorType ) {
            case WandParserConstants.OP_ASSIGN:
                writeString( "=" );
                break;
            case WandParserConstants.OP_MUL_ASSIGN:
                writeString( "*=" );
                break;
            case WandParserConstants.OP_DIV_ASSIGN:
                writeString( "/=" );
                break;
            case WandParserConstants.OP_MOD_ASSIGN:
                writeString( "%=" );
                break;
            case WandParserConstants.OP_ADD_ASSIGN:
                writeString( "+=" );
                break;
            case WandParserConstants.OP_SUB_ASSIGN:
                writeString( "-=" );
                break;
            default:
                assert false: "Unknown operator: " + WandParserConstants.tokenImage[operatorType];
        }
        
        return data;
    }
    
    
    private static final String INDENT_STRING = "\t";
    private boolean beginningOfLine = true;
    private int indentLevel = 0;
    
    private void writeString( String str ) {
        if ( beginningOfLine ) {
            // indent
            beginningOfLine = false;
            
            for ( int i = 0; i < indentLevel; i++ ) {
                writeString( INDENT_STRING );
            }
        }
        
        out.print( str );
    }
    
    private void writeNewline( ) {
        out.println( "" );
        beginningOfLine = true;
    }
    
    private void writeNewline( String str ) {
        writeString( str );
        writeNewline( );
    }
    
    private void writeBlockStart( ) {
        writeNewline( "{" );
        indentLevel++;
    }
    
    private void writeBlockEnd( ) {
        indentLevel--;
        writeNewline( "}" );
    }
}
