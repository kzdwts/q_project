package top.kangyong.study01.design.pattern.memento;

/**
 * 备忘录模式 demo
 * * <p>
 * * 行为型模式
 * * @author Kang Yong
 *
 * @date 2022/10/9
 * @since 1.0.0
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("state #1");
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("state #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #4");

        System.out.println("current states is: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("first state is: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("second state is: " + originator.getState());
    }
}
