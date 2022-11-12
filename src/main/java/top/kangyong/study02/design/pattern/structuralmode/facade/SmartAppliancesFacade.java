package top.kangyong.study02.design.pattern.structuralmode.facade;

/**
 * 外观类，用户主要和该类对象进行交互
 * <p>
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/11/12
 * @since 1.0.0
 */
public class SmartAppliancesFacade {

    // 聚合 电灯、电视机、空调
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    /**
     * 通过语音控制
     *
     * @param message {@link String}
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("我还听不懂你说的");
        }
    }

    /**
     * 一键关闭
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    private void off() {
        light.off();
        tv.off();
        airCondition.off();
    }

    /**
     * 一键打开功能
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    private void on() {
        light.on();
        tv.on();
        airCondition.on();
    }
}
