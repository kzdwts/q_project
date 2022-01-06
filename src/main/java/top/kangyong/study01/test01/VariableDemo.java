package top.kangyong.study01.test01;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 可变参数测试
 * @author: kangyong
 * @date: 2019/4/10 17:44
 * @version: v1.0
 */
public class VariableDemo {

    public static void main(String[] args) {
        int[] ages = {3, 6, 9, 8, 5, 4, 7, 2, 1};
        show(ages);
    }

    public static void show(int...a) {
        System.out.println(Arrays.toString(a));
    }
}
