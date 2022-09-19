package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 工厂方法模式
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 咖啡店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        // 咖啡工厂
        CoffeeFactory coffeeFactory = new AmericanCoffeeFactory();
        coffeeStore.setCoffeeFactory(coffeeFactory);

        // 点咖啡
        Coffee coffee = coffeeStore.orderCoffee();

        String name = coffee.getName();
        System.out.println(name);

        /**
         * 符合开闭原则
         * 如果新增一个咖啡类型，只需要继承Coffee类，实现CoffeeFactory就行，无需改动原先的代码
         */
    }

}
