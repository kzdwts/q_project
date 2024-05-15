package top.kangyong.study02.mthreadcode;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture多线程测试
 *
 * @author Kang Yong
 * @date 2024/5/15
 * @since 1.0.0
 */
public class CompletableFutureDemo {

    @Test
    public void show1() {
        int a1 = 1000;
        int a2 = 1000;
        int a3 = 1000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < a1; i++) {
            System.out.println("a1康永正在赚钱： " + i + " 元");
        }
        for (int i = 0; i < a2; i++) {
            System.out.println("a1张坤正在赚钱： " + i + " 元");
        }
        for (int i = 0; i < a3; i++) {
            System.out.println("a1小郑君正在赚钱： " + i + " 元");
        }

        long end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));
    }

    @Test
    public void show2() {
        int a1 = 100000;
        int a2 = 100000;
        int a3 = 100000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < a1; i++) {
            System.out.println("a1kang康永正在赚钱： " + i + " 元");
        }
        for (int i = 0; i < a2; i++) {
            System.out.println("a1张坤正在赚钱： " + i + " 元");
        }
        for (int i = 0; i < a3; i++) {
            System.out.println("a1小郑君正在赚钱： " + i + " 元");
        }

        long end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));
    }

    @Test
    public void show3() {
        int a1 = 100000;
        int a2 = 100000;
        int a3 = 100000;

        long start = System.currentTimeMillis();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < a1; i++) {
                System.out.println("a1kang康永正在赚钱： " + i + " 元");
            }
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < a2; i++) {
                System.out.println("a1张坤正在赚钱： " + i + " 元");
            }
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < a3; i++) {
                System.out.println("a1小郑君正在赚钱： " + i + " 元");
            }
        });

        long zhong = System.currentTimeMillis();

        CompletableFuture.allOf(future1, future2, future3).join();

        long end = System.currentTimeMillis();
        System.out.println("(zhong - start) = " + (zhong - start));
        System.out.println("(end - zhong) = " + (end - zhong));
        System.out.println("(end - start) = " + (end - start));

    }
}
