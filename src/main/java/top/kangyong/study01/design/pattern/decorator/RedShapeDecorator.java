package top.kangyong.study01.design.pattern.decorator;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/8/24
 * @since 1.0.0
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
