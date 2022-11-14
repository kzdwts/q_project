package top.kangyong.study01.design.pattern.visitor;

/**
 * 实现类：键盘
 * <p>
 * 访问者模式
 *
 * @author Kang Yong
 * @date 2022/11/14
 * @since 1.0.0
 */
public class KeyBoard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
