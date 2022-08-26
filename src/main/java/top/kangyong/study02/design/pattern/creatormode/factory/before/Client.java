package top.kangyong.study02.design.pattern.creatormode.factory.before;

/**
 * 工厂模式 咖啡店点咖啡
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/21
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 创建咖啡店类
        CoffeeStore store = new CoffeeStore();

        // 点咖啡
        Coffee coffee = store.orderCoffee("Latte");
        System.out.println(coffee.getName());

        Coffee americanCoffee = store.orderCoffee("American");
        System.out.println(americanCoffee.getName());
    }
}
