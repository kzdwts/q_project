package top.kangyong.study01.design.pattern.prototype;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2022/6/27
 * @since 1.0.0
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside square drow() method");
    }
}
