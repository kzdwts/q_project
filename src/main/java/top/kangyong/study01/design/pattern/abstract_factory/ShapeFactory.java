package top.kangyong.study01.design.pattern.abstract_factory;

import top.kangyong.study01.design.pattern.abstract_factory.color.Color;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Circle;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Rectangle;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Shape;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Square;

/**
 * shape工厂
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case "circle":
                shape = new Circle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "square":
                shape = new Square();
                break;
        }
        return shape;
    }

    @Override
    Color getColor(String colorType) {
        return null;
    }
}
