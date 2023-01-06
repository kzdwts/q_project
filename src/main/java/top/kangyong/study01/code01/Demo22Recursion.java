package top.kangyong.study01.code01;

/**
 * 求阶乘的值（递归方法）
 *
 * @author Kang Yong
 * @date 2023/1/6
 * @since 1.0.0
 */
public class Demo22Recursion {

    public static void main(String[] args) {
        // 利用递归方法求5!
        long sum = calcFactorial(5);
        System.out.println("sum = " + sum);
    }

    private static long calcFactorial(int num) {
        if (num > 1) {
            return num * calcFactorial(num - 1);
        }
        return 1;
    }

}
