package top.kangyong.study01.design.pattern.abstract_factory;

import top.kangyong.study01.design.pattern.abstract_factory.color.Color;
import top.kangyong.study01.design.pattern.abstract_factory.shape.Shape;

/**
 * demo
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @link {https://www.runoob.com/design-pattern/abstract-factory-pattern.html}
 * @date 2022/6/9
 * @since 1.0.0
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory("shape");

        Shape circle = factory.getShape("circle");
        circle.draw();

        AbstractFactory colorF = FactoryProducer.getFactory("color");
        Color red = colorF.getColor("red");
        red.fill();

    }
}
