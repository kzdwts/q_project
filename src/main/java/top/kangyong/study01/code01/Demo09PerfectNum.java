package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 完数
 * User: kangyong
 * Date: 2018/12/29 17:12
 */
public class Demo09PerfectNum {

    public static void main(String[] args) {
        /*
        一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程
        28 = 1 + 2 + 4 + 7 + 14
        找出1000以内的所有完数
         */
        getPerfectNum1();
    }

    /**
     * 求1000以内的所有完数
     */
    private static void getPerfectNum1() {
        System.out.println("开始计算...");
        // 一轮遍历数字
        for (int i = 2; i < 1000; i++) {
            int sum = 0;
            // 二轮处理结果
            for (int j = 1; j < Math.sqrt(i); j++) {
                // 如果能除尽
                if (i % j == 0) {
                    // 如果是1，只加1
                    if (j == 1) {
                        sum += j;
                    } else {
                        // 如果不是1，加当前的数和除以的结果
                        sum += j + (i / j);
                    }
                }
            }
            // 是否为完全数
            if (sum == i) {
                System.out.println(i + "是完全数");
            }
        }
    }
}
