package top.kangyong.study02.design.pattern.behaviormode.observer;

/**
 * 观察者角色接口
 * <p>
 * 观察者模式（发布-订阅模式）
 *
 * @author Kang Yong
 * @date 2023/1/3
 * @since 1.0.0
 */
public interface Observer {

    void update(String message);
}
