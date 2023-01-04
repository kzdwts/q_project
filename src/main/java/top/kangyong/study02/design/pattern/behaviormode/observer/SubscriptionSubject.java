package top.kangyong.study02.design.pattern.behaviormode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色类（模拟公众号）
 * <p>
 * 观察者模式（发布-订阅模式）
 *
 * @author Kang Yong
 * @date 2023/1/3
 * @since 1.0.0
 */
public class SubscriptionSubject implements Subject {

    // 定义一个集合，用来存储观察者对象
    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }

}
