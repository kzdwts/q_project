package top.kangyong.study01.design.pattern.facade;

/**
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/8/27
 * @since 1.0.0
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square: draw");
    }
}
