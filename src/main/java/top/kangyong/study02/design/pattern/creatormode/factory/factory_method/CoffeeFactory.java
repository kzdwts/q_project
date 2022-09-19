package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 工厂方法
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public interface CoffeeFactory {

    /**
     * 创建coffee的方法
     *
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/9/19
     */
    Coffee createCoffee();

}
