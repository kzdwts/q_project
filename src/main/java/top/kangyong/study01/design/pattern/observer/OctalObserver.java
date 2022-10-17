package top.kangyong.study01.design.pattern.observer;

/**
 * 观察者模式
 *
 * @author Kang Yong
 * @date 2022/10/14
 * @since 1.0.0
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toBinaryString(subject.getState()));
    }

}
