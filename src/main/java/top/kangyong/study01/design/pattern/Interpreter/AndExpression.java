package top.kangyong.study01.design.pattern.Interpreter;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2022/9/16
 * @since 1.0.0
 */
public class AndExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
