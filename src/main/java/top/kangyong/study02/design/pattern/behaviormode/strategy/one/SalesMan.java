package top.kangyong.study02.design.pattern.behaviormode.strategy.one;

/**
 * 促销员（环境类）
 * <p>
 * 策略模式
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class SalesMan {

    /**
     * 聚合策略类对象
     */
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 由促销员展示促销活动
     *
     * @author Kang Yong
     * @date 2022/12/18
     */
    public void salesManShow() {
        strategy.show();
    }
}
