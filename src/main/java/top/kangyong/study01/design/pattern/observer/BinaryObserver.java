package top.kangyong.study01.design.pattern.observer;

/**
 * 观察者模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/14
 * @since 1.0.0
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
