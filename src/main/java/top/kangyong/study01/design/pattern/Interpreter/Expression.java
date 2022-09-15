package top.kangyong.study01.design.pattern.Interpreter;

/**
 * 解释器模式
 *
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/15
 * @since 1.0.0
 */
public interface Expression {

    boolean interpret(String context);
}
