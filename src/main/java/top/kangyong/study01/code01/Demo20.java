package top.kangyong.study01.code01;

/**
 * 求数列之和。
 *
 * @author Kang Yong
 * @date 2023/1/4
 * @since 1.0.0
 */
public class Demo20 {

    public static void main(String[] args) {
        // 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
        int z = 2;
        int m = 1;

        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            System.out.println("第 " + i + "项为：" + z + "/" + m);
            sum += z / m;

            // 下一个
            int tmp = z;
            z = z + m;
            m = tmp;
        }

        System.out.println("前 20 项的和为：" + sum);
    }

}
