package top.kangyong.study01.design.pattern.decorator;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/8/24
 * @since 1.0.0
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
