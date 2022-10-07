package top.kangyong.study02.design.pattern.creatormode.factory.config_factory;

/**
 * test
 * <p>
 * 模式扩展：配置文件+工厂模式
 * <p>
 * 符合开闭原则
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee);
        System.out.println(coffee.getName());

        System.out.println("=================");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte);
        System.out.println(latte.getName());

    }
}
