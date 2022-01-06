package top.kangyong.study01.threadtest.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/8/30 18:05
 * @version: v1.0
 */
public class TestThreadForNum {

    public static void main(String[] args) {
        new ThreadForNum1().start();
        new ThreadForNum2().start();
    }
}
