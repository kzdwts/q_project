package top.kangyong.study02.design.pattern.creatormode.factory.static_factory;

/**
 * 静态工厂
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/31
 * @since 1.0.0
 */
public class SimpleCoffeeFactory {

    /**
     * 生产咖啡
     *
     * @param type {@link String} 咖啡类型
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/8/31
     */
    public static Coffee createCoffee(String type) {
        Coffee coffee = null;

        if ("american".equalsIgnoreCase(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equalsIgnoreCase(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您点的咖啡没有");
        }

        return coffee;
    }
}
