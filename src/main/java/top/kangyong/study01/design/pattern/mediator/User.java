package top.kangyong.study01.design.pattern.mediator;

/**
 * 中介者模式
 *
 * @author Kang Yong
 * @date 2022/10/4
 * @since 1.0.0
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
