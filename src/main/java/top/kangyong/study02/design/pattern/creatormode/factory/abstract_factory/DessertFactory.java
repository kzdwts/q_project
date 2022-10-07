package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 甜品工厂
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public interface DessertFactory {

    /**
     * 生产咖啡
     *
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/10/7
     */
    Coffee createCoffee();

    /**
     * 生产甜品
     *
     * @return {@link Dessert}
     * @author Kang Yong
     * @date 2022/10/7
     */
    Dessert createDessert();

}
