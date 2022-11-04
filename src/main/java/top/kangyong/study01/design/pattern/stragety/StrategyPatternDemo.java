package top.kangyong.study01.design.pattern.stragety;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 策略模式
 * @author: kangyong
 * @date: 2020/9/15 14:32
 * @version: v1.0
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        /*
        策略模式：
        优点：1、算法可以自由切换
             2、避免使用多重条件判断
             3、扩展性良好
        缺点：1、策略类会增多
             2、所有策略类都需要对外暴露
         */
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

    }

}
