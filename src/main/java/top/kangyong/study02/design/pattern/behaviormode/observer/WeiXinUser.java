package top.kangyong.study02.design.pattern.behaviormode.observer;

/**
 * 具体的观察者角色类
 * <p>
 * 观察者模式（发布-订阅模式）
 *
 * @author Kang Yong
 * @date 2023/1/4
 * @since 1.0.0
 */
public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }

}
