package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

/**
 * 策略类（具体算法实现类）
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class AStrategyProcessor implements StrategyProcessor {

    @Override
    public boolean support(String abc) {
        return abc.equals("春节");
    }

    @Override
    public void show(String abc) {
        System.out.println("春节活动:买一送一");
    }
}
