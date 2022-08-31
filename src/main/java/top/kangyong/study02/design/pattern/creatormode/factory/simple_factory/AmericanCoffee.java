package top.kangyong.study02.design.pattern.creatormode.factory.simple_factory;

/**
 * 简单工厂模式 美式咖啡
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/21
 * @since 1.0.0
 */
public class AmericanCoffee extends Coffee {

    @Override
    public String getName() {
        return "美式咖啡";
    }
}
