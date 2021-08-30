package threadtest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 多线程 模拟多窗口卖票
 * @author: Kang Yong
 * @date: 2021/8/30 17:16
 * @version: v1.0
 */
public class SaleWindow implements Runnable {

    private int id = 100;


    /**
     * 窗口卖票
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                if (id > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖了编号为：" + id + "的火车票");
                }
                id--;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
