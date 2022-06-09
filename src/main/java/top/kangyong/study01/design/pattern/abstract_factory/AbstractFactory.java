package top.kangyong.study01.design.pattern.abstract_factory;

import top.kangyong.study01.design.pattern.abstract_factory.color.Color;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Shape;

/**
 * 抽象工厂
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public abstract class AbstractFactory {

    abstract Shape getShape(String shape);

    abstract Color getColor(String color);

}
