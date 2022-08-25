package top.kangyong.study01.design.pattern.decorator;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/8/25
 * @since 1.0.0
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Circle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\n Circle of red border");
        redCircle.draw();

        System.out.println("\n Rectangle of red border");
        redRectangle.draw();
    }
}
