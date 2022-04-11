package top.kangyong.study02.mthreadcode;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService 使用
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
public class ExecutorServiceDemo {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Test
    public void demo01() {
        System.out.println("===START===");
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> masync());
        }

        // 断点，不然程序结束，看不到结果
        System.out.println("===END===");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private void masync() {
        System.out.println("多线程异步，业务执行中");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
