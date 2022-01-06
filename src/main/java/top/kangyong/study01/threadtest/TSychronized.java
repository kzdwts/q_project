package top.kangyong.study01.threadtest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2021/1/7 10:52
 * @version: v1.0
 */
public class TSychronized implements Runnable {
    static int i = 0;

    public void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            increase();
        }
    }

    public static void main(String[] args) {
        TSychronized tSychronized = new TSychronized();
        Thread aThread = new Thread(tSychronized);
        Thread bThread = new Thread(tSychronized);

        aThread.start();
        bThread.start();

        System.out.println("i = " + i);
    }
}
