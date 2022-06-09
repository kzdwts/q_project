package top.kangyong.study01.design.pattern.abstract_factory;

/**
 * 工厂创造器/生成器
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if ("shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        }

        if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }

        return null;
    }
}
