package top.kangyong.study01.design.pattern.mediator;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(new Date()) + " [ " + user.getName() + " ]: " + message);
    }
}
