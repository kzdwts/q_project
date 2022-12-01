package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

/**
 * 具体策略类（具体算法）
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class CStrategyProcessor implements StrategyProcessor {

    @Override
    public boolean support(String abc) {
        return abc.equals("圣诞节");
    }

    @Override
    public void show(String abc) {
        System.out.println("圣诞节：满1000加1元换购任意200以下商品");
    }
}
