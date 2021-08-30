package threadtest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/8/30 18:04
 * @version: v1.0
 */
public class ThreadForNum1 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            System.out.println("1");
        }
    }
}
