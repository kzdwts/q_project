package top.kangyong.study01.threadtest.demo03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 小孩吃水果
 * @author: Kang Yong
 * @date: 2021/8/31 17:46
 * @version: v1.0
 */
public class Child extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Kuang.kuang) {
                // 1、框里没有水果了，就让小孩休息
                if (Kuang.kuang.size() == 0) {
                    try {
                        Kuang.kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 2、小孩吃水果
                Kuang.kuang.remove("apple");
                System.out.println("小孩吃了一个水果，目前框里有 " + Kuang.kuang.size() + " 个水果");

                // 3、唤醒农夫继续放水果
                Kuang.kuang.notify();
            }

            // 模拟小孩吃水果的速度
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
