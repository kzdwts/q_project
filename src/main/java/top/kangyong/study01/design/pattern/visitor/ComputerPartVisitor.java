package top.kangyong.study01.design.pattern.visitor;

/**
 * 访问者模式
 *
 * @author Kang Yong
 * @date 2022/11/14
 * @since 1.0.0
 */
public interface ComputerPartVisitor {

    void visit(KeyBoard keyBoard);

    void visit(Monitor monitor);
}
