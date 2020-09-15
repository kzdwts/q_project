package design.mode.stragety;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 策略模式 上下文角色
 * @author: kangyong
 * @date: 2020/9/15 14:26
 * @version: v1.0
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 上下文接口
     *
     * @param num1
     * @param num2
     * @return
     */
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
