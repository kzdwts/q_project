package top.kangyong.study01.design.pattern.Interpreter;

/**
 * 解释器模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/17
 * @since 1.0.0
 */
public class InterpreterPatternDemo {

    /**
     * 规则：robot和john是男性
     *
     * @return {@link Expression}
     * @author Kang Yong
     * @date 2022/9/18
     */
    public static Expression getMaleExpression() {
        TerminalExpression robot = new TerminalExpression("robot");
        TerminalExpression john = new TerminalExpression("john");

        return new OrExpression(robot, john);
    }

    /**
     * 规则：julie是个已婚女性
     *
     * @return {@link Expression}
     * @author Kang Yong
     * @date 2022/9/19
     */
    public static Expression getMarriedWomanExpression() {
        TerminalExpression julie = new TerminalExpression("julie");
        TerminalExpression married = new TerminalExpression("married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {

    }
}
