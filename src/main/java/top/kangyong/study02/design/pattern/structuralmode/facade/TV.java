package top.kangyong.study02.design.pattern.structuralmode.facade;

/**
 * 电视机类
 * <p>
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/11/12
 * @since 1.0.0
 */
public class TV {

    /**
     * 打开电视机
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void on() {
        System.out.println("打开电视机...");
    }

    /**
     * 关闭电视机
     *
     * @author Kang Yong
     * @date 2022/11/12
     */
    public void off() {
        System.out.println("关闭电视机...");
    }
}
