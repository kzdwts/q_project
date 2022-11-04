package top.kangyong.study01.design.pattern.stragety;

/**
 * 策略模式
 * <p>
 * 行为型模式
 *
 * @Description: 策略模式接口实现类 减法
 * @author: kangyong
 * @date: 2020/9/15 14:21
 * @version: v1.0
 */
public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
