package top.kangyong.study01.threaddemo;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/10/29 17:34
 * @version: v1.0
 */
public class AddDemo {

    private int count = 0;

    public void doAdd(CountDownLatch countDownLatch) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 25; j++) {
                        count++;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        AddDemo add = new AddDemo();
        add.doAdd(countDownLatch);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(add.getCount());
    }

}
