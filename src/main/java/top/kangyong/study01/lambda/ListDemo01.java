package top.kangyong.study01.lambda;

import org.junit.Test;

import java.util.*;

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
//        list2.add("F");
//        list2.add("B");
//        List<String> list2 = Collections.emptyList();

        // 交集
        list1.retainAll(list2);

        list1.forEach(System.out::println);
        System.out.println("=============华丽的分割线============");
        list2.forEach(System.out::println);
    }

    /**
     * 判断是否存在交集
     * disjoint
     * <p>
     * 如果存在交集，isDisjoint将为false，否则为true
     */
    @Test
    public void testDisjoint() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("H");
        list2.add("E");
        list2.add("F");
        list2.add("G");

        // 判断是否存在交集
        boolean disjointFlag = Collections.disjoint(list1, list2);
        System.out.println("disjointFlag = " + disjointFlag);

        list1.forEach(System.out::println);
        System.out.println("=============华丽的分割线============");
        list2.forEach(System.out::println);
    }


    /**
     * 判断是否存在交集 Integer测试
     * disjoint
     * <p>
     * 如果存在交集，isDisjoint将为false，否则为true
     */
    @Test
    public void testDisjointInteger() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(9);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // 判断是否存在交集：如果存在交集，isDisjoint将为false，否则为true
        boolean disjointFlag = Collections.disjoint(list1, list2);
        System.out.println("disjointFlag = " + disjointFlag);

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

    /**
     * List<Long> contains 测试
     *
     * @author Kang Yong
     * @date 2023/11/30
     */
    @Test
    public void testLongContains() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(2L);
        list.add(1720277314876395520L);

        Long num1 = 1L;
        Long num2 = 1720277314876395520L;

        System.out.println("list.contains(1L) = " + list.contains(1L));
        System.out.println("list.contains(1L) = " + list.contains(num1));
        System.out.println("list.contains(1720277314876395520L) = " + list.contains(1720277314876395520L));
        System.out.println("list.contains(num2) = " + list.contains(num2));
    }

    /**
     * List<String> contains 测试
     *
     * @author Kang Yong
     * @date 2023/11/30
     */
    @Test
    public void testStringContains() {
        List<String> list = new ArrayList<>();
        list.add("1L");
        list.add("3L");
        list.add("2L");
        list.add("1720277314876395520L");

        System.out.println("list.contains(1L) = " + list.contains("1L"));
        System.out.println("list.contains(1720277314876395520L) = " + list.contains("1720277314876395520L"));
    }

    /**
     * List<String> contains 测试
     *
     * @author Kang Yong
     * @date 2023/11/30
     */
    @Test
    public void testListEmptyContains() {
        List<String> list = Collections.emptyList();

        System.out.println("list.contains(1L) = " + list.contains("1L"));
        System.out.println("list.contains(1720277314876395520L) = " + list.contains("1720277314876395520L"));
    }

}
