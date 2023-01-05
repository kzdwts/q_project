package top.kangyong.study01.code01;

/**
 * 数列求和.
 *
 * @author Kang Yong
 * @date 2023/1/5
 * @since 1.0.0
 */
public class Demo21Calc {

    public static void main(String[] args) {
        // 求1+2!+3!+...+20!的和

        // 方法一，双重循环(先打印)
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + "!=" + i);
            for (int j = i - 1; j > 0; j--) {
                System.out.print(" x " + j);
            }
            System.out.println();
        }
        System.out.println("===================");

        // 方法一，计算
        long sum1 = 0;
        for (int i = 1; i <= 20; i++) {
            long current = 1;
            for (int j = i - 1; j > 0; j--) {
                current = current * (j + 1);
            }
            sum1 += current;
            System.out.println("i = " + i + "\tsum1 = " + sum1 + "\tcurrent = " + current);
        }
        System.out.println("===================");

        // 方法二，单层循环，当前值x下一个值
        long sum2 = 0;
        long current2 = 1;
        for (int i = 1; i <= 20; i++) {
            current2 = current2 * i;
            sum2 += current2;

            System.out.println("i = " + i + "\tsum2 = " + sum2 + "\tcurrent2 = " + current2);
        }

    }
}
