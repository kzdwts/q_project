package top.kangyong.study01.design.pattern.abstract_factory.shape;

/**
 * 原❤
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public class Circle implements Shape {
    /**
     * draw
     *
     * @author Kang Yong
     * @date 2022/6/9
     */
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
