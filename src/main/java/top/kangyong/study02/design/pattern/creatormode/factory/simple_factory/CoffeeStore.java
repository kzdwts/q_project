package top.kangyong.study02.design.pattern.creatormode.factory.simple_factory;

/**
 * 简单工厂模式 咖啡商店
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/31
 * @since 1.0.0
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee(type);

        // 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
