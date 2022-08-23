package top.kangyong.study01.design.pattern.decorator;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/8/23
 * @since 1.0.0
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
