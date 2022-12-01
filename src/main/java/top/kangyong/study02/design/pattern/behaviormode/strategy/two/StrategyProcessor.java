package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

/**
 * 策略类（抽象 ）
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public interface StrategyProcessor {

    /**
     * 根据参数判断当前场景是否支持
     *
     * @param abc {@link String}
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2022/12/1
     */
    boolean support(String abc);

    /**
     * 执行业务
     *
     * @param abc {@link String}
     * @author Kang Yong
     * @date 2022/12/1
     */
    void show(String abc);
}
