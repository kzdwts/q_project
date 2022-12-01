package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        String abc = "春节";

        StrategyProcessorComposite composite = new StrategyProcessorComposite();
        composite.show(abc);

        System.out.println("=========");
        abc = "中秋节";
        composite.show(abc);

        System.out.println("=========");
        abc = "圣诞节";
        composite.show(abc);
    }

}
