package top.kangyong.study01.design.pattern.stragety;

/**
 * 策略模式
 * <p>
 * 行为型模式
 *
 * @Description: 策略模式接口定义
 * @author: kangyong
 * @date: 2020/9/15 14:18
 * @version: v1.0
 */
public interface Strategy {

    /**
     * 运算操作
     *
     * @param num1
     * @param num2
     * @return
     */
    int doOperation(int num1, int num2);

}
