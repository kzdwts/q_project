package top.kangyong.study02.mthreadcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池基本使用
 *
 * @author Kang Yong
 * @date 2023/3/30
 * @since 1.0.0
 */
public class ExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池，包含2个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 提交三个任务给线程池处理
        executorService.submit(new TaskExample("Task 1"));
        executorService.submit(new TaskExample("Task 2"));
        executorService.submit(new TaskExample("Task 3"));

        // 关闭线程池
        executorService.shutdown();
        System.out.println("THE END!");
        Thread.sleep(5000);
    }

}
