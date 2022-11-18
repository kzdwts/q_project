package top.kangyong.study01.design.pattern.visitor;


/**
 * 实体访问者
 * <p>
 * 访问者模式
 *
 * @author Kang Yong
 * @date 2022/11/18
 * @since 1.0.0
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("Displaying KeyBoard...");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor...");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse...");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer...");
    }

}
