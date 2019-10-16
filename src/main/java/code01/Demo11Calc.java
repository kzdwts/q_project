package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 组数
 * @author: kangyong
 * @date: 2019/10/16 16:06
 * @version: v1.0
 */
public class Demo11Calc {

    public static void main(String[] args) {
        /*
        有1、2、3、4四个数字，能组成多少个互不相同且一个数字中无重复数字的三位数？并把他们都输入
         */

        // 计数
        int count = 0;
        // 第一个数
        for (int i = 1; i < 5; i++) {
            // 第二个数
            for (int j = 1; j < 5; j++) {
                // 第三个数
                for (int k = 1; k < 5; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                        System.out.println( "" + i + j + k);
                    }
                }
            }
        }

        System.out.println("供可以组成个数：" + count);
    }
}
