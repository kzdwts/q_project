package top.kangyong.study01.design.pattern.stragety;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 策略模式接口实现类 乘法
 * @author: kangyong
 * @date: 2020/9/15 14:23
 * @version: v1.0
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
