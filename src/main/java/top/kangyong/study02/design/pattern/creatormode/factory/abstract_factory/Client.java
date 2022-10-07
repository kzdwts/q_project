package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 生产同一个产品族的对象
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 生产意大利风味的咖啡和甜品
        ItalyDessertFactory factory = new ItalyDessertFactory();
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();

    }

}
