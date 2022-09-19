package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 工厂方法模式
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public class CoffeeStore {

    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    /**
     * 点咖啡
     *
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/9/19
     */
    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.createCoffee();

        // 加配料
        coffee.addSugar();
        coffee.addMilk();

        return coffee;
    }

}
