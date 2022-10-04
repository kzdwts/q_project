package top.kangyong.study01.design.pattern.mediator;

import java.util.Date;

/**
 * 中介者模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/4
 * @since 1.0.0
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[ " + user.getName() + "]: " + message);
    }
}
