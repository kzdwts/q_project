package top.kangyong.study01.design.pattern.visitor;

/**
 * test
 * <p>
 * 访问者模式
 *
 * @author Kang Yong
 * @date 2022/11/19
 * @since 1.0.0
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
