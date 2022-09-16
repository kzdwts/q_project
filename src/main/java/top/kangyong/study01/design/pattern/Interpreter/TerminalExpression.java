package top.kangyong.study01.design.pattern.Interpreter;

/**
 * 解释器模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/15
 * @since 1.0.0
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
