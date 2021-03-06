package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 集合处理
 * @author: kangyong
 * @date: 2020/9/16 19:21
 * @version: v1.0
 */
public class ListDemo01 {

    /**
     * 求交集
     */
    @Test
    public void testRetainAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("E");
        list2.add("F");
        list2.add("B");

        // 交集
        list1.retainAll(list2);

        list1.forEach(System.out::println);
        System.out.println("=============华丽的分割线============");
        list2.forEach(System.out::println);
    }

    /**
     * 求并集
     */
    @Test
    public void testAddAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("E");
        list2.add("F");
        list2.add("B");

        // 并集
        list1.addAll(list2);
        list1.forEach(System.out::println);
        System.out.println("=============华丽的分割线============");
        list2.forEach(System.out::println);
    }

    /**
     * 求差集
     */
    @Test
    public void testRemoveAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("E");
        list2.add("F");
        list2.add("B");

        // 差集
        list1.removeAll(list2);
        list1.forEach(System.out::println);
        System.out.println("=============华丽的分割线============");
        list2.forEach(System.out::println);
    }

    /**
     * 测试map存基本类型
     */
    @Test
    public void testMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 100);
        map.put(2, 200);
        map.put(1, 555);
        byte b = 1;
        System.out.println("从键获取值：" + map.get(b));
    }

}
