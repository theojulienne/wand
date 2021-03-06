package wand.core;

import wand.parser.*;

public abstract class WandVisitor implements WandParserVisitor {
    public Object visitChildren(SimpleNode node, Object data) {
        return node.childrenAccept( this, data );
    }
    
    public void visitFrom( SimpleNode node, Object data ) {
        node.jjtAccept( this, data );
    }
    
    public Object visit(SimpleNode node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTProgram node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTDeclarations node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTDecoratedFunctionOrClassDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTDecoratedFunctionDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTDecoratedClassDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTModifiers node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTModifier node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTClassDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTQualifiedIdentifierList node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTClassFieldDeclarations node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTClassFieldDeclarator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTFunctionDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTFunctionParameters node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTFunctionParameter node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTBuiltinType node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTArrayType node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTQualifiedIdentifier node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTAssignExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTConditionalExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTInfixExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTUnaryOperator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTUnaryExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTPrefixExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTPostfixExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTCastExpression node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTFunctionCall node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTArguments node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTAssignOperator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTInfixOperator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTPrefixOperator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTPostfixOperator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTIntegerLiteral node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTFloatingPointLiteral node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTBooleanLiteral node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTNullLiteral node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTBlockStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTIfStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTWhileStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTDoWhileStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTLoopStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTBreakStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTContinueStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTLocalVariableDeclarationStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTAssertStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTReturnStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTExpressionStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTVariableDeclarator node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTIdentifier node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTNamespaceDeclaration node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTUsingStatement node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTQualifiedNamespaceName node, Object data) { return visitChildren(node, data); }
    public Object visit(ASTNamespaceName node, Object data) { return visitChildren(node, data); }
}
