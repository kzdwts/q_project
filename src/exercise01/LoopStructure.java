package exercise01;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 循环控制练习
 * @author: kangyong
 * @date: 2019/4/9 14:55
 * @version: v1.0
 */
public class LoopStructure {

    /**
     * 用三种循环控制求出100以内，前5个3的倍数的数字
     */

    /**
     * do-while结构
     */
    @Test
    public void testDoWhile() {
        int i = 0;
        int num = 0;
        do {
            i++;

            if (i % 3 == 0) {
                num++;
                System.out.println("第" + num + "个3的倍数是：" + i);
            }
        } while (i <= 100 && num < 5);
    }

    /**
     * while结构
     */
    @Test
    public void testWhile() {
        int i = 0;
        int num = 0;
        while (i < 100 && num < 5) {
            i++;
            if (i % 3 == 0) {
                num++;
                System.out.println("第" + num + "个3的倍数是：" + i);
            }
        }
    }

    /**
     * for结构
     */
    @Test
    public void testFor() {
        int num = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                num++;
                System.out.println("第" + num + "个3的倍数是：" + i);
                if (num >= 5) {
                    return;
                }
            }
        }
    }
}
