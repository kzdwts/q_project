package top.kangyong.study02.design.pattern.behaviormode.strategy.one;

/**
 * 具体策略类，封装算法
 * <p>
 * 策略模式
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class StrategyC implements Strategy {

    @Override
    public void show() {
        System.out.println("圣诞节：满1000加1元换购任意200以下商品");
    }

}
