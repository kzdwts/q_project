package top.kangyong.study01.design.pattern.Interpreter;

/**
 * 解释器模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/16
 * @since 1.0.0
 */
public class OrExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
