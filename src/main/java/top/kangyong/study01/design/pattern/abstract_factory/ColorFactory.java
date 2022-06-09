package top.kangyong.study01.design.pattern.abstract_factory;

import top.kangyong.study01.design.pattern.abstract_factory.color.Blue;
import top.kangyong.study01.design.pattern.abstract_factory.color.Color;
import top.kangyong.study01.design.pattern.abstract_factory.color.Green;
import top.kangyong.study01.design.pattern.abstract_factory.color.Red;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Circle;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Rectangle;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Shape;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Square;

/**
 * color工厂
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
       return null;
    }

    @Override
    Color getColor(String colorType) {
        Color color = null;
        switch (colorType) {
            case "red":
                color = new Red();
                break;
            case "blue":
                color = new Blue();
                break;
            case "green":
                color = new Green();
                break;
        }
        return color;
    }
}
