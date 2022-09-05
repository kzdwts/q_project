package top.kangyong.study02.design.pattern.creatormode.factory.static_factory;

/**
 * 静态工厂模式（习惯，常用）
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/31
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");

        String name = coffee.getName();
        System.out.println(name);
    }
}
