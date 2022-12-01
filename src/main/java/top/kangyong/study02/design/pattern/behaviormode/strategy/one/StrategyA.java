package top.kangyong.study02.design.pattern.behaviormode.strategy.one;

/**
 * 具体策略类 封装算法
 * <p>
 * 策略模式
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("春节活动:买一送一");
    }

}
