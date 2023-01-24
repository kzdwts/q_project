package top.kangyong.study02.design.pattern.behaviormode.mediator;

/**
 * 具体的同事角色类
 * <p>
 * 中介者模式
 *
 * @author Kang Yong
 * @date 2023/1/24
 * @since 1.0.0
 */
public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message) {
        mediator.constact(message, this);
    }
}
