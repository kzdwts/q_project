package threadtest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2021/1/7 15:05
 * @version: v1.0
 */
public class TJavaThread extends Thread {
    static int count;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TJavaThread thread = new TJavaThread();
        thread.start();
        // 不加join就不等待执行结束，输出的结果就不是10000
//        thread.join();
        System.out.println(count);
    }
}
