package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 意大利风味甜品工厂
 * 生产意大利风味的甜品和咖啡
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
