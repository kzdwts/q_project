package top.kangyong.study02.design.pattern.behaviormode.strategy.one;

/**
 * test
 * <p>
 * 策略模式：
 * 优点：
 * 策略类之间可以自由切换
 * 易于扩展
 * 避免使用多重条件选择语句（if-else），充分体现面向对象设计思想
 * <p>
 * 缺点：
 * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类
 * 策略模式将造成很多策略类，可以通过使用享元模式在一定程度上减少对象的策略
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 春节
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();

        System.out.println("===============");
        // 中秋节
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();

        System.out.println("===============");
        // 圣诞节
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();

    }

}
