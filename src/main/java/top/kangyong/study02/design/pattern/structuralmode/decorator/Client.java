package top.kangyong.study02.design.pattern.structuralmode.decorator;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/11/7
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 点一份炒饭
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + "  " + food.cost() + "元");

        System.out.println("======================");

        // 在上面的炒饭中加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + "  " + food.cost() + "元");

        System.out.println("======================");

        // 再加一个鸡蛋
        // 在上面的炒饭中加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + "  " + food.cost() + "元");

        // 再加一个培根
        // 在上面的炒饭中加一个鸡蛋
        food = new Bacon(food);
        System.out.println(food.getDesc() + "  " + food.cost() + "元");
    }

}
