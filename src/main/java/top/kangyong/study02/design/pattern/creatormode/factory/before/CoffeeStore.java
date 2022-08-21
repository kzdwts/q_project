package top.kangyong.study02.design.pattern.creatormode.factory.before;

/**
 * 工厂模式 咖啡店
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/21
 * @since 1.0.0
 */
public class CoffeeStore {

    /**
     * 点咖啡
     *
     * @param type {@link String} 咖啡类型：American、Latte
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/8/21
     */
    public Coffee orderCoffee(String type) {
        // 声明coffee的类型，根据不同类型创建不同子类对象
        Coffee coffee = null;
        if ("American".equalsIgnoreCase(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equalsIgnoreCase(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您点的咖啡没有");
        }

        // 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
