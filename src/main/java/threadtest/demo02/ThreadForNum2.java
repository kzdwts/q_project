package threadtest.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/8/30 18:04
 * @version: v1.0
 */
public class ThreadForNum2 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            synchronized (MyLock.o) {
                System.out.println("2");
                MyLock.o.notify();
                try {
                    MyLock.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
