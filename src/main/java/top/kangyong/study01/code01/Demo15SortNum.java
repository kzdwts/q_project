package top.kangyong.study01.code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 排序
 * @author: kangyong
 * @date: 2019/10/23 15:13
 * @version: v1.0
 */
public class Demo15SortNum {

    public static void main(String[] args) {
        /*
        输入三个整数x,y,z，请把这三个数由小到大输出。
         */
        System.out.println("请输入x、y、z三个数：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.close();

        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        if (x < z) {
            int t = x;
            x = z;
            z = t;
        }
        if (y < z) {
            int t = y;
            y = z;
            z = t;
        }

        System.out.println("排序后：" + x + " > " + y + " > " + z);
    }

}
