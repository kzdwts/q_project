package top.kangyong.study01.threadtest.demo03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 农夫放水果
 * @author: Kang Yong
 * @date: 2021/8/31 17:41
 * @version: v1.0
 */
public class Framer extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Kuang.kuang) {
                // 1、框满了就休息
                if (Kuang.kuang.size() == 10) {
                    try {
                        Kuang.kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 2、放苹果
                Kuang.kuang.add("apple");
                System.out.println("农夫向框里放了一个水果，目前框里有 " + Kuang.kuang.size() + " 个水果");

                // 3、唤醒小孩吃水果
                Kuang.kuang.notify();
            }

            // 模拟控制速度
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
