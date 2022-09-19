package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 方法工厂模式 拿铁咖啡工厂
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

}
