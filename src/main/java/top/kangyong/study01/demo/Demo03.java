package top.kangyong.study01.demo;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: Math, Random
 * @author: kangyong
 * @date: 2019/7/4 11:27
 * @version: v1.0
 */
public class Demo03 {

    public static void main(String[] args) {
//        testMath();

        testRandom();
    }

    /**
     * 测试Random类
     */
    private static void testRandom() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(10));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt());
        }


    }

    /**
     * 测试Math类
     */
    private static void testMath() {
        System.out.println(Math.E);
        System.out.println(Math.PI);
        int a = 12;
        int b = 18;

        // 12
        System.out.println(Math.abs(a));
        // 18
        System.out.println(Math.max(a, b));
        // 12
        System.out.println(Math.min(a, b));

        System.out.println("----------------------------");
        // Math随机数
        for (int i = 0; i < 100; i++) {
            System.out.println(Math.random());

        }
    }
}
