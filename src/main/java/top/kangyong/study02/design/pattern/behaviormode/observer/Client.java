package top.kangyong.study02.design.pattern.behaviormode.observer;

/**
 * test
 * <p>
 * 观察者模式（发布-订阅模式）
 * <p>
 * 优点：
 * 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系
 * 被观察者发送通知，所有注册的观察者都会收到消息【可以实现广播机制】
 * <p>
 * 缺点：
 * 如果观察者非常多的话，那么所有的观察者收到被观察者发送的通知会耗时
 * 如果被观察者有循环依赖的话，那么被观察者发送通知会使观察者循环调用，会导致系统奔溃
 * <p>
 * 使用场景：
 * 对象间存在一对多关系，一个对象的状态发生改变会影响其他对象
 * 当一个抽象模型有两个方面，其中一个方面依赖于另一方面
 *
 * @author Kang Yong
 * @date 2023/1/4
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪悟能"));
        subject.attach(new WeiXinUser("沙悟净"));

        // 公众号更新，发出消息给订阅者（观察者对象）
        subject.notify("新年快乐");
    }

}
