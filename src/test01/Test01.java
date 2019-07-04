package test01;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 循环和try-catch的嵌套
 * User: kangyong
 * Date: 2018/12/20 17:11
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        t1.test1();
        System.out.println("------------------------");
        t1.test2();
    }

    /**
     * 循环里面放try-catch
     */
    public void test1() {
        for (int i = 0; i < 9; i++) {
            try {
                int x;
                if (i == 3) {
                    x = 1 / 0;
                } else {
                    x = i;
                    System.out.println("x=" + x);
                }
            } catch (Exception e) {
                System.out.println("异常");
            }
        }
    }

    /**
     * try-catch里面放循环
     */
    public void test2() {
        try {
            for (int i = 0; i < 9; i++) {
                int x;
                if (i == 3) {
                    x = 1 / 0;
                } else {
                    x = i;
                    System.out.println("x==" + x);
                }
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }

    @Test
    public void test03() {
        int i = 0;
        do {
            i++;
        } while (i < 100);
        System.out.println(i);

        while (i > 10) {
            i--;
        }
        System.out.println(i);
    }

    @Test
    public void test04() {
//        int[] nums = new int[3];
//        int nums2[] = {};
//        String[] names = new String[]{"王丽丽", "宁玉玉", "", "'"};
//        String[] names2 = new String[3];
//        names2 = names;

        // 在栈分配内存
        int[] scores;
        // 在堆分配内存
        scores = new int[6];

        // 动态初始化
        int[][] nums = new int[3][2];
        // 静态初始化
        int[][] nums2 = new int[][]{{1, 2}, {2, 3}, {1, 2, 3}};
        int[][] nums3 = {{1, 2}, {2, 3}, {1, 2, 3}};

        for (int i = 0; i < scores.length; i++) {
            scores[i] = i * (int)(Math.random() * 10);
        }
        System.out.println(Arrays.toString(scores));
        Arrays.parallelSort(scores);
        System.out.println(Arrays.toString(scores));

        String[] names = {"张三", "李四", "王五", "赵六", "田七"};
        for (String name:names) {
            System.out.println(name);
        }
    }
}
