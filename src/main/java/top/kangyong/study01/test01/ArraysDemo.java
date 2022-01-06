package top.kangyong.study01.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/2/27 14:35
 * @version: v1.0
 */
public class ArraysDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String arrs[] = list.toArray(new String[list.size()]);
    }
}
