package top.kangyong.study02.design.pattern.behaviormode.mediator;

/**
 * 具体的同事角色类
 * <p>
 * 中介者模式
 *
 * @author Kang Yong
 * @date 2023/1/25
 * @since 1.0.0
 */
public class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * 和中介联系
     *
     * @param message {@link String}
     * @author Kang Yong
     * @date 2023/1/25
     */
    public void constact(String message) {
        mediator.constact(message, this);
    }

    /**
     * 获取信息
     *
     * @param message {@link String}
     * @author Kang Yong
     * @date 2023/1/25
     */
    public void getMessage(String message) {
        System.out.println("房主：" + name + " 获取到的信息是：" + message);
    }

}
