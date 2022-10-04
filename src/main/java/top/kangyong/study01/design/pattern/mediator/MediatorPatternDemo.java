package top.kangyong.study01.design.pattern.mediator;

import java.text.SimpleDateFormat;

/**
 * 中介者模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/4
 * @since 1.0.0
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {

        User robet = new User("robet");
        User john = new User("john");

        robet.sendMessage("Hi, john!");
        john.sendMessage("Hi, robet. Nice to meet you");
    }
}
