package top.kangyong.study02.keywordcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile 关键字测试
 *
 * @author Kang Yong
 * @date 2023/3/29
 * @since 1.0.0
 */
public class CounterVolatileDemo {

    private volatile int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }


    private int num = 0;

    public void numIncrement() {
        num++;
    }
    public int getNum() {
        return num;
    }


    public static void main(String[] args) {
        final CounterVolatileDemo counter = new CounterVolatileDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    counter.increment();

                    counter.numIncrement();
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){

        }

        System.out.println("counter.getCount() = " + counter.getCount());
        System.out.println("counter.getNum() = " + counter.getNum());
    }
}
