package top.kangyong.study01.code01;

/**
 * 计算年龄
 *
 * @author Kang Yong
 * @date 2023/1/6
 * @since 1.0.0
 */
public class Demo23GuessAge {

    public static void main(String[] args) {
        // 有5个人坐在一起，问第五个人多少岁？
        // 他说比第4个人大2岁。
        // 问第4个人岁数，
        // 他说比第3个人大2岁。
        // 问第三个人，又说比第2人大两岁。
        // 问第2个人，说比第一个人大两岁。
        // 最后问第一个人，他说是10岁。
        // 请问第五个人多大？

        // 方法一，直接算
        int age = 10;
        int tmpAge = 0;

        System.out.println("第1个人，" + age + "岁");

        tmpAge = age + 2;
        System.out.println("第2个人，" + tmpAge + "岁");

        tmpAge = tmpAge + 2;
        System.out.println("第3个人，" + tmpAge + "岁");

        tmpAge = tmpAge + 2;
        System.out.println("第4个人，" + tmpAge + "岁");

        tmpAge = tmpAge + 2;
        System.out.println("第5个人，" + tmpAge + "岁");

        System.out.println("===华*丽*的*分*割*线===");

        // 方法二：找规律，通过循环
        int numAge = 10;
        System.out.println("第1个人，" + numAge + "岁");
        for (int i = 2; i <= 5; i++) {
            numAge = numAge + 2;
            System.out.println("第" + i + "个人，" + numAge + "岁");
        }

    }
}
