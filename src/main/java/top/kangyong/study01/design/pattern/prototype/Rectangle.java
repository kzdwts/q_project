package top.kangyong.study01.design.pattern.prototype;


/**
 * 长方形
 * <p>
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/6/26
 * @since 1.0.0
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside rectangle drow() method");
    }
}
