package code01;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 斐波那契数列
 * User: kangyong
 * Date: 2018/12/4 23:11
 */
public class Demo01Fib {

    public static void main(String[] args) {
        /*
        古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
        小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的第几个月兔子数量");
        int n = sc.nextInt();
        int num = fib1(n);
        // 使用占位符输出
        System.out.println(MessageFormat.format("第{0}个月有兔子总数为{1}", n, num));
        sc.close();
    }

    /**
     * 斐波那契方法一
     *
     * @param n 第n个月
     * @return
     */
    private static int fib1(int n) {
        int f1 = 2;
        int f2 = 2;
        int fn = 2;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2; // 当前月为前两个月的和
            f1 = f2; // 上上个月赋值为上个月的数量
            f2 = fn; // 上个月赋值为当前的数量
        }
        return fn;
    }






}
