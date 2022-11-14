package top.kangyong.study02.design.pattern.structuralmode.facade;

/**
 * test
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/11/12
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        SmartAppliancesFacade saf = new SmartAppliancesFacade();

        saf.say("打开家电");

        System.out.println("==========");

        saf.say("关闭家电");
    }
}
