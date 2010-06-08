/* Generated By:JavaCC: Do not edit this line. WandParserVisitor.java Version 5.0 */
package wand.parser;

public interface WandParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTProgram node, Object data);
  public Object visit(ASTDeclarations node, Object data);
  public Object visit(ASTDecoratedFunctionDeclaration node, Object data);
  public Object visit(ASTModifiers node, Object data);
  public Object visit(ASTModifier node, Object data);
  public Object visit(ASTFunctionDeclaration node, Object data);
  public Object visit(ASTFunctionParameters node, Object data);
  public Object visit(ASTFunctionParameter node, Object data);
  public Object visit(ASTBuiltinType node, Object data);
  public Object visit(ASTArrayType node, Object data);
  public Object visit(ASTQualifiedIdentifier node, Object data);
  public Object visit(ASTAssignExpression node, Object data);
  public Object visit(ASTConditionalExpression node, Object data);
  public Object visit(ASTInfixExpression node, Object data);
  public Object visit(ASTUnaryExpression node, Object data);
  public Object visit(ASTPostfixExpression node, Object data);
  public Object visit(ASTFunctionCall node, Object data);
  public Object visit(ASTArguments node, Object data);
  public Object visit(ASTAssignOperator node, Object data);
  public Object visit(ASTInfixOperator node, Object data);
  public Object visit(ASTUnaryOperator node, Object data);
  public Object visit(ASTPostfixOperator node, Object data);
  public Object visit(ASTIntegerLiteral node, Object data);
  public Object visit(ASTFloatingPointLiteral node, Object data);
  public Object visit(ASTBooleanLiteral node, Object data);
  public Object visit(ASTNullLiteral node, Object data);
  public Object visit(ASTLocalVariableDeclarationStatement node, Object data);
  public Object visit(ASTBlockStatement node, Object data);
  public Object visit(ASTIfStatement node, Object data);
  public Object visit(ASTAssertStatement node, Object data);
  public Object visit(ASTReturnStatement node, Object data);
  public Object visit(ASTExpressionStatement node, Object data);
  public Object visit(ASTVariableDeclarator node, Object data);
  public Object visit(ASTIdentifier node, Object data);
}
/* JavaCC - OriginalChecksum=5e5a73b04714ca4afa9d1e1bd1e8d9be (do not edit this line) */
