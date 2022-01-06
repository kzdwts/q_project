package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 猜数
 * @author: kangyong
 * @date: 2019/10/16 16:22
 * @version: v1.0
 */
public class Demo13GuessNum {

    public static void main(String[] args) {

        /*
        一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少
         */

        int sqrt1, sqrt2;
        for (int i = 1; i < 10000; i++) {
            // 开平方
            sqrt1 = (int) Math.sqrt(i + 100);
            sqrt2 = (int) Math.sqrt(i + 168);
            // 完全平方数
            if ((sqrt1 * sqrt1 == (i + 100)) && (sqrt2 * sqrt2 == (i + 168))) {
                System.out.println("完全平方数：" + i);
            }
        }
    }

}
