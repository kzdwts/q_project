package top.kangyong.study01.design.pattern.observer;

/**
 * 观察者模式
 *
 * @author Kang Yong
 * @date 2022/10/15
 * @since 1.0.0
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
