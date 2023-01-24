package top.kangyong.study02.design.pattern.behaviormode.mediator;

/**
 * 抽象同事类
 * <p>
 * 中介者模式
 *
 * @author Kang Yong
 * @date 2023/1/23
 * @since 1.0.0
 */
public abstract class Person {

    protected String name;

    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
