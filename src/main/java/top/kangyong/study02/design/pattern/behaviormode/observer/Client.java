package top.kangyong.study02.design.pattern.behaviormode.observer;

/**
 * test
 * <p>
 * 观察者模式（发布-订阅模式）
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
