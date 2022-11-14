package top.kangyong.study02.design.pattern.structuralmode.facade;

/**
 * 电灯类
 * <p>
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/11/12
 * @since 1.0.0
 */
public class Light {

    /**
     * 开灯
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void on() {
        System.out.println("打开电灯...");
    }

    /**
     * 关灯
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void off() {
        System.out.println("关闭电灯...");
    }
}
