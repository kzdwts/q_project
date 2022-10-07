package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 生产美式风味的甜品和咖啡
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class AmericanDessertFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
