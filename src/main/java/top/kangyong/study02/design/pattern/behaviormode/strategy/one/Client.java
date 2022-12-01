package top.kangyong.study02.design.pattern.behaviormode.strategy.one;

/**
 * test
 * <p>
 * 策略模式
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
