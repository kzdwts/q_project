package top.kangyong.study02.design.pattern.structuralmode.facade;

/**
 * 空调类
 * <p>
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/11/12
 * @since 1.0.0
 */
public class AirCondition {

    /**
     * 开空调
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void on() {
        System.out.println("打开空调...");
    }

    /**
     * 关闭空调
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void off() {
        System.out.println("关闭空调...");
    }

}
