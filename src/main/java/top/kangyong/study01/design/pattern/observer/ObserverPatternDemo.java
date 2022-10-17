package top.kangyong.study01.design.pattern.observer;

/**
 * 观察者模式
 *
 * @author Kang Yong
 * @date 2022/10/16
 * @since 1.0.0
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
