package top.kangyong.study01.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * <p>
 * 行为型模式。
 *
 * @author Kang Yong
 * @date 2022/10/13
 * @since 1.0.0
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
