package top.kangyong.study02.keywordcode;

/**
 * 在多线程中，如果多个线程同时对同一个变量进行修改，则有可能出现原子性问题
 *
 * @author Kang Yong
 * @date 2023/3/30
 * @since 1.0.0
 */
public class VolatileAtomicityDemo {

    public static volatile int count = 0;
    public static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        t1.start();
        t2.start();

//        等待该进程终止
        t1.join();
        t2.join();

        System.out.println("count = " + count);

        /*
        运行这段代码，会发现最终输出的 count 值是不确定的，有可能是 20000，也有可能是其他值。
        这是因为在执行自增操作时，有可能出现原子性问题，
        即多个线程同时读取到了同一个值，然后各自进行自增操作，最后再将自增后的值写回到变量中，
        这就会导致计算结果不正确。
         */

//        加锁解决多线程问题
        Object lock = new Object();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    num++;
                }
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    num++;
                }
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("num = " + num);
    }
}
