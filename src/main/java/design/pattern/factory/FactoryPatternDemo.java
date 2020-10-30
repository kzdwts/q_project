package design.pattern.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 工厂模式
 * @author: kangyong
 * @date: 2020/10/30 16:11
 * @version: v1.0
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        // 创建一个工厂工具
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("rectangle");
        shape1.draw();

        Shape shape2 = factory.getShape("square");
        shape2.draw();

        Shape shape3 = factory.getShape("circle");
        shape3.draw();
    }

}
