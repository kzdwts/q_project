package code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 相加运算
 * User: kangyong
 * Date: 2018/12/29 16:04
 */
public class Demo08AddNum {

    public static void main(String[] args) {
        /*
        求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
        例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int num = sc.nextInt();
        System.out.println("请输入相加次数：");
        int tim = sc.nextInt();
        sc.close();

        // 相加
        System.out.println(add1(num, tim));

    }

    /**
     * 按规则相加
     *
     * @param num
     * @param tim
     * @return
     */
    private static int add1(int num, int tim) {
        // 结果
        int sum = 0;
        // 每次循环要加的数
        int current = num;
        // 循环次数
        int i = 0;
        while (i++ < tim) {
            // 相加
            sum += current;
            // 当前数变为下一个要加的数
            current += num * Math.pow(10, i);
            // current = current * 10 + num;
        }
        return sum;
    }
}
