package top.kangyong.study02.design.pattern.behaviormode.strategy.jdk;

import java.util.Arrays;
import java.util.Comparator;

/**
 * jdk 里面Arrays.sort()方法使用了策略模式
 *
 * @author Kang Yong
 * @date 2022/12/22
 * @since 1.0.0
 */
public class ArraysSortDemo {

    public static void main(String[] args) {
        Integer[] data = {12, 3, 6, 10, 8, 9};

        // new Comparator既是策略类
        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(data));
    }
}
