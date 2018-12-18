package code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 素数
 * User: kangyong
 * Date: 2018/12/5 00:04
 */
public class Demo02Prime {

    public static void main(String[] args) {
        /*
        判断101-200之间有多少个素数，并输出所有素数
        判断素数的方法：质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
         */
        // showPrime1(101, 200);
        showPrime2(101, 200);
    }

    /**
     * 输出区间的素数
     *
     * @param start
     * @param end
     */
    public static void showPrime1(int start, int end) {
        // 循环次数
        int cycles = 0;
        // 总数
        int count = 0;
        // 遍历区间
        for (int i = start; i < end; i++) {
            // 对这个数进行处理
            // 从2除到这个数的一半
            for (int j = 2; j <= (i / 2); j++) {
                cycles++;
                if (i % j == 0) {
                    // 能除尽，不是素数,退出当前循环
                    break;
                }
                if (j == (i / 2)) {
                    count++;
                    System.out.println(i);
                }
            }
        }
        System.out.println("共有：" + count);
        System.out.println("共执行循环" + cycles);
    }

    /**
     * 输出区间的素数
     * （使用根号方法，减少循环次数）
     *
     * @param start
     * @param end
     */
    public static void showPrime2(int start, int end) {
        // 循环次数
        int cycle = 0;
        int count = 0;
        // 遍历
        for (int i = start; i < end; i++) {
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                cycle++;
                // 处理这个数
                // 判断判断当前j
                if (i % j == 0) {
                    // 不是素数，退出当前循环
                    break;
                }
                if (j == (int) Math.sqrt(i)) {
                    count++;
                    System.out.println(i);
                }
            }
        }
        System.out.println("共有素数：" + count);
        System.out.println("共执行循环：" + cycle);
    }


}
