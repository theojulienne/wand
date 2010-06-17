package wand.backends.c;

import java.io.*;

import wand.core.*;
import wand.parser.*;

public class CCodeGenerator extends WandVisitor {
    private PrintStream out;
    
    private ASTType currentType;
    
    public void setOutputStream( OutputStream out ) {
        this.out = new PrintStream( out );
    }
    
    public void generate( ASTProgram program ) {
        writeNewline( "// Generated by the Wand compiler" );
        writeNewline( "// DO NOT EDIT" );
        writeNewline( );
        writeNewline( "#include <stdio.h>" );
        writeNewline( "#include <assert.h>" );
        writeNewline( "#include <math.h>" );
        writeNewline( );
        program.jjtAccept( this, null );
    }
    
    public Object visit(ASTBlockStatement node, Object data) {
        writeBlockStart( );
        visitChildren(node, data);
        writeBlockEnd( );
        
        return data;
    }
    
    public Object visit(ASTFunctionDeclaration node, Object data) {
        String functionName = node.getFunctionName( );
        
        ASTType returnType = (ASTType)node.getReturnType( );
        ASTFunctionParameters parameters = (ASTFunctionParameters)node.getFunctionParameters( );
        ASTBlockStatement body = (ASTBlockStatement)node.getFunctionBody( );
        
        writeNewline( "// begin function " + functionName );
        
        returnType.accept( this, data );
        writeString( " " );
        writeString( functionName );
        writeString( "( " );
        parameters.accept( this, data );
        writeString( " ) " );
        
        body.accept( this, data );
        writeNewline( "// end function " + functionName );
        
        return data;
    }
    
    public Object visit(ASTFunctionParameters node, Object data) {
        boolean first = true;
        
        for ( WandNode child: node ) {
            if ( !first ) {
                writeString( ", " );
            }
            
            child.accept( this, data );
            
            first = false;
        }
        
        return data;
    }
    
    public Object visit(ASTFunctionParameter node, Object data) {
        WandNode type = node.getType( );
        WandNode identifier = node.getIdentifier( );
        
        type.accept( this, data );
        writeString( " " );
        identifier.accept( this, data );
        
        return data;
    }
    
    public Object visit(ASTBuiltinType node, Object data) {
        writeString( node.getTypeName( ) );
        
        return data;
    }
    
    public Object visit(ASTArrayType node, Object data) {
        // FIXME: this is really wrong :P
        writeString( node.getTypeName( ) );
        
        return data;
    }
    
    public Object visit(ASTLocalVariableDeclarationStatement node, Object data) {
        //writeNewline( "// declare type: " + node.getType() );
        //writeNewline( "// declare names: " );
        
        currentType = node.getType( );
        
        int numVars = node.getNumVariables( );
        for ( int i = 0; i < numVars; i++ ) {
            WandNode child = node.getVariable( i );
            
            //writeNewline( "//     " + child );
            child.accept( this, data );
        }
        
        currentType = null;
        
        return data;
    }
    
    public Object visit(ASTVariableDeclarator node, Object data) {
        // type
        currentType.accept( this, data );
        
        writeString( " " );
        
        // variable name
        WandVariable identifier = (WandVariable)node.getIdentifier( );
        this.visit( identifier, data );
        
        // initializer
        WandNode initializer = node.getInitializer( );
        if ( initializer != null ) {
            writeString( " = " );
            initializer.accept( this, data );
        }
        
        writeNewline( ";" );
        
        return data;
    }
    
    public Object visit(ASTFunctionCall node, Object data) {
        boolean firstNode = true;
        for ( WandNode child: node ) {
            if ( firstNode ) {
                firstNode = false;
                // FIXME: this should eventually be a WandVariable
                // and work automatically with accept()
                ASTIdentifier identifier = (ASTIdentifier)child;
                writeString( identifier.getIdentifier() );
                writeString( "( " );
                continue;
            }
            
            child.accept( this, data );
        }
        writeString( " )" );
        
        return data;
    }
    
    public Object visit(ASTArguments node, Object data) {
        boolean firstNode = true;
        
        for ( WandNode child: node ) {
            if ( firstNode ) {
                firstNode = false;
            } else {
                // add commas before subsequent arguments
                writeString( ", " );
            }
            
            child.accept( this, data );
        }
        
        return data;
    }
    
    public Object visit(ASTInfixExpression node, Object data) {
        WandNode lhs = (WandNode)node.getLHS( );
        WandNode rhs = (WandNode)node.getRHS( );
        ASTInfixOperator op = (ASTInfixOperator)node.getOperator( );
        
        // some operators don't work as "a OP b" in C, such as pow
        if ( op.getOperatorType() == WandParserConstants.OP_POW ) {
            // FIXME: pow type needs to be determined from the types of sub expressions
            writeString( "(int)pow( (" );
            lhs.accept( this, data );
            writeString( "), (" );
            rhs.accept( this, data );
            writeString( ") )" );
            return data;
        }
        
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
        WandNode rhs = (WandNode)node.getValueExpression( );
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
    
    public Object visit(ASTReturnStatement node, Object data) {
        writeString( "return (" );
        visitChildren(node, data);
        writeNewline( ");" );
        
        return data;
    }
    
    public Object visit(ASTIfStatement node, Object data) {
        WandNode condition = node.getCondition( );
        WandNode thenStatement = node.getThenStatement( );
        WandNode elseStatement = node.getElseStatement( );
        
        writeString( "if (" );
        condition.accept( this, data );
        writeNewline( ") " );
        thenStatement.accept( this, data );
        
        if ( elseStatement != null ) {
            writeNewline( " else " );
            elseStatement.accept( this, data );
        }
        
        return data;
    }
    
    public Object visit(ASTWhileStatement node, Object data) {
        WandNode condition = node.getCondition( );
        WandNode loopBody = node.getLoopBody( );
        
        writeString( "while (" );
        condition.accept( this, data );
        writeNewline( ") " );
        loopBody.accept( this, data );
        
        return data;
    }
    
    public Object visit(ASTDoWhileStatement node, Object data) {
        WandNode condition = node.getCondition( );
        WandNode loopBody = node.getLoopBody( );
        
        writeString( "do " );
        loopBody.accept( this, data );
        writeString( "while (" );
        condition.accept( this, data );
        writeNewline( ");" );
        
        return data;
    }
    
    public Object visit(ASTLoopStatement node, Object data) {
        WandNode condition = node.getCondition( );
        WandNode loopBody = node.getLoopBody( );
        
        writeString( "do " );
        loopBody.accept( this, data );
        writeString( "while ( !(" );
        if ( condition != null ) {
            condition.accept( this, data );
        } else {
            writeString( " 0 " );
        }
        writeNewline( ") );" );
        
        return data;
    }
    
    public Object visit(ASTBreakStatement node, Object data) {
        writeNewline( "break;" );
        return data;
    }
    
    public Object visit(ASTContinueStatement node, Object data) {
        writeNewline( "continue;" );
        return data;
    }
    
    public Object visit(ASTAssertStatement node, Object data) {
        WandNode expression = node.getExpression( );
        WandNode message = node.getMessage( );
        
        if ( message == null ) {
            writeString( "assert( " );
            expression.accept( this, data );
            writeNewline( " );" );
        } else {
            writeString( "if ( " );
            expression.accept( this, data );
            writeString( " ) " );
            writeBlockStart( );
            // FIXME: output message as string safely somehow
            //message.accept( this, data );
            writeNewline( "assert(0);" );
            writeBlockEnd( );
        }
        
        return data;
    }
    
    public Object visit(ASTPostfixExpression node, Object data) {
        WandNode expression = node.getExpression( );
        WandNode operator = node.getOperator( );
        
        writeString( "(" );
        expression.accept( this, data );
        writeString( ")" );
        operator.accept( this, data );
        
        return data;
    }
    
    public Object visit(ASTPostfixOperator node, Object data) {
        int operatorType = node.getOperatorType( );
        
        switch ( operatorType ) {
            case WandParserConstants.OP_INC:
                writeString( "++" );
                break;
            case WandParserConstants.OP_DEC:
                writeString( "--" );
                break;
            default:
                assert false: "Unknown postfix operator: " + WandParserConstants.tokenImage[operatorType];
        }
        
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
            case WandParserConstants.OP_XOR:
                writeString( "^" );
                break;
            case WandParserConstants.OP_EQUALS:
                writeString( "==" );
                break;
            case WandParserConstants.OP_NOT_EQUAL:
                writeString( "!=" );
                break;
            case WandParserConstants.OP_CMP_LTE:
                writeString( "<=" );
                break;
            case WandParserConstants.OP_CMP_LT:
                writeString( "<" );
                break;
            case WandParserConstants.OP_CMP_GTE:
                writeString( ">=" );
                break;
            case WandParserConstants.OP_CMP_GT:
                writeString( ">" );
                break;
            default:
                assert false: "Unknown infix operator: " + WandParserConstants.tokenImage[operatorType];
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
                assert false: "Unknown assignment operator: " + WandParserConstants.tokenImage[operatorType];
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
