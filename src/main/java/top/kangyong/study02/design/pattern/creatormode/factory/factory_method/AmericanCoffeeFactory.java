package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 工厂方法模式 美式咖啡工厂对象，专门用来生产美式咖啡
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public class AmericanCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

}
