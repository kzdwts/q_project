package top.kangyong.study02.design.pattern.behaviormode.observer;

/**
 * 抽象主题角色类
 * <p>
 * 观察者模式（发布-订阅模式 ）
 *
 * @author Kang Yong
 * @date 2023/1/3
 * @since 1.0.0
 */
public interface Subject {

    /**
     * 添加订阅者（添加观察者对象）
     *
     * @param observer {@link Observer}
     * @author Kang Yong
     * @date 2023/1/3
     */
    void attach(Observer observer);

    /**
     * 删除订阅者（删除观察者对象）
     *
     * @param observer {@link Observer}
     * @author Kang Yong
     * @date 2023/1/3
     */
    void detach(Observer observer);

    /**
     * 通知订阅者更新消息
     *
     * @param message {@link String}
     * @author Kang Yong
     * @date 2023/1/3
     */
    void notify(String message);
}
