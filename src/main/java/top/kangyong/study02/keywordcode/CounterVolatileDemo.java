package top.kangyong.study02.keywordcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


    public static void main(String[] args) {
        final CounterVolatileDemo counter = new CounterVolatileDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    counter.increment();
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){

        }

        System.out.println("counter.getCount() = " + counter.getCount());
    }
}
