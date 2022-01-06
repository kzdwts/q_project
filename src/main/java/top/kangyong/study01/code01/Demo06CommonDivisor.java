package top.kangyong.study01.code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 最大公约数&最小公倍数
 * User: kangyong
 * Date: 2018/12/21 11:32
 */
public class Demo06CommonDivisor {

    public static void main(String[] args) {
        /*
        输入两个正整数m和n，求其最大公约数和最小公倍数
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int m = sc.nextInt();
        System.out.println("亲输入第二个数：");
        int n = sc.nextInt();
        // 关闭输入流
        sc.close();

        System.out.println("开始时间" + System.currentTimeMillis());
        // 执行计算
        // divisor1(m, n);
        divisor2(m, n);

        System.out.println("结束时间" +System.currentTimeMillis());
    }

    /**
     * 输出最大公约数和最小公倍数
     *
     * @param m
     * @param n
     */
    public static void divisor1(Integer m, Integer n) {
        // 最大公约数
        // 取两者大
        int max = m > n ? m : n;
        int min = m > n ? n : m;
        // 遍历寻找最大公约数
        for (int i = min; i >= 1; i--) {
            if ((max % i == 0) && (min % i == 0)) {
                System.out.println(m + "和" + n + "最大公约数：" + i);
                break;
            }
        }

        // 最小公倍数
        for (int i = max; ; i++) {
            if ((i % max == 0) && (i % min == 0)) {
                System.out.println(m + "和" + n + "最小公倍数：" + i);
                break;
            }
        }
    }

    /**
     * 最大公约数，最小公倍数
     */
    public static void divisor2(int m, int n) {
        int maxDiv = deff(m, n);
        int minMul = m * n / maxDiv;
        System.out.println(m + "和" + n + "最大公约数：" + maxDiv);
        System.out.println(m + "和" + n + "最小公倍数：" + minMul);
    }

    /**
     * 最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private static int deff(int x, int y) {
        int t;
        // 换位操作，保证x是两者最大
        if (x < y) {
            t = x;
            x = y;
            y = t;
        }

        // 求最大公约数
        while (y != 0) {
            if (x == y) {
                return x;
            } else {
                int k = x % y;
                x = y;
                y = k;
            }
        }

        return x;
    }

}
