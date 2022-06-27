package top.kangyong.study01.design.pattern.prototype;

/**
 * 园
 * <p>
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/6/27
 * @since 1.0.0
 */
public class Circle extends Shape {

    public Circle() {
        type = "Cricle";
    }

    @Override
    public void draw() {
        System.out.println("Inside cricle drow() method");
    }
}
