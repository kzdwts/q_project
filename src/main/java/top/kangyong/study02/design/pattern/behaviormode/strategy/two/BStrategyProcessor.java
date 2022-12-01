package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

/**
 * 具体策略类（具体的算法）
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class BStrategyProcessor implements StrategyProcessor {

    @Override
    public boolean support(String abc) {
        return abc.equals("中秋节");
    }

    @Override
    public void show(String abc) {
        System.out.println("中秋节活动：满200减50");
    }
}
