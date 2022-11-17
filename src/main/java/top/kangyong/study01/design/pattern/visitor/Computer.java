package top.kangyong.study01.design.pattern.visitor;

/**
 * 实现类：电脑
 * <p>
 * 访问者模式
 *
 * @author Kang Yong
 * @date 2022/11/17
 * @since 1.0.0
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[]{new Mouse(), new KeyBoard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

}
