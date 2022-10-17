package top.kangyong.study01.design.pattern.observer;

/**
 * 观察者模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/13
 * @since 1.0.0
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
