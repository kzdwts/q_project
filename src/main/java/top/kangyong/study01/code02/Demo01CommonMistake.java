package top.kangyong.study01.code02;

import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 常见十大错误集锦
 * @author: Kang Yong
 * @date: 2021/8/10 14:00
 * @version: v1.0
 */
public class Demo01CommonMistake {

    /**
     * 将一个数组转化为列表
     */
    @Test
    public void testArrayToList() {
        String[] nameArr = new String[]{"王丽丽", "储小姣", "李子木"};
        List<String> nameList = Arrays.asList(nameArr);
        /*
        这个操作会报错，因为上一步操作返回的ArrayList全称是java.top.kangyong.study01.util.Arrays.ArrayList，并不是java.top.kangyong.study01.util.ArrayList
         */
//        nameList.add("孙柯瑶");
        nameList.forEach(System.out::println);


        List<String> nameArrayList = new ArrayList<>(Arrays.asList(nameArr));
        nameArrayList.add("陆智航");
        nameArrayList.forEach(System.out::println);

        // 换一种方法 使用Lists
    }

    /**
     * 判断一个数组是否包含一个值
     */
    @Test
    public void testJudgeArraysContainsVal() {
        boolean flag = false;
        String[] nameArr = new String[]{"王丽丽", "储小姣", "李子木"};
        /*
        方法一: 虽然可实现，但是转换为数组也要花时间，不建议这么做
         */
        List<String> nameList = new ArrayList<>(Arrays.asList(nameArr));
        flag = nameList.contains("王丽丽");
        System.out.println(flag);

        /*
        方法二，推荐
         */
        flag = Arrays.asList(nameArr).contains("王丽丽");
        System.out.println(flag);

        /*
        方法三，传统方法
         */
        for (String s : nameArr) {
            if ("王丽丽".equals(s)) {
                flag = true;
                System.out.println(flag);
                System.out.println("找到了");
                break;
            }
        }

    }

    /**
     * 在一个循环中删除一个列表中的元素
     */
    @Test
    public void testRemoveOneFromList() {
        /*
        错误示范1
         */
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("第 " + (i + 1) + "次循环");
            list1.remove(i);
            System.out.println("list.size() = " + list1.size());
        }
        System.out.println(list1);
        System.out.println("=============================");

        /*
        错误示范2,会抛出异常 ConcurrentModificationException
         */
        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
//        for (String s : list2) {
//            if ("a".equals(s)) {
//                list2.remove(s);
//            }
//        }
//        System.out.println(list2);

        /*
        正确示范 注意.next()要在.remove()之前调用
         */
        List<String> list3 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("a".equals(s)) {
                it.remove();
            }
        }
        System.out.println(list3);
    }

    /**
     * HashMap和HashTable
     */
    @Test
    public void testHashMapAndTable() {
        /*
        HashMap与HashTable最重要的区别，HashTable是同步的
         */
        HashMap<String, Object> hashMap = new HashMap<>();

        /*
        所以这种写法并不常见
         */
        Hashtable<String, Object> hashtable = new Hashtable<>();
    }

    /**
     * 在集合中使用原始类型
     */
    @Test
    public void testUseOriginalTypeInCollection() {
        List<String> list = new ArrayList<>();
        /*
        使用原生类型集合是危险的，因为原生类型集合跳过了泛型集合检查，并且不是安全的
         */
        add(list, 10);
        String s = list.get(0);
        System.out.println(s);
    }

    public static void add(List list, Object obj) {
        list.add(obj);
    }

    /**
     * 访问修饰符
     */
    @Test
    public void testShowLevel() {
        /*
        修饰符
        public
        protected
        缺省（default）
        private
         */
    }

    /**
     * ArrayList和LinkedList选择
     */
    @Test
    public void testShooseList() {
        /*
        如果有大量的增加删除操作，并且没有很多随机访问操作，应该首选LinkedList，性能更佳
         */

        List<String> list1 = new ArrayList<>();

        List<String> list2 = new LinkedList<>();
    }

    /**
     * 可变与不可变
     */
    @Test
    public void testStringChoose() {
        /*
        String
        StringBuilder
        StringBuffer
         */
    }

    /**
     * 创建String对象
     */
    @Test
    public void testCreateString() {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String c = new String("abc");
        String d = new String("abc");
        System.out.println(c == d);
        System.out.println(c.equals(d));

        System.out.println(a == c);
        System.out.println(a.equals(c));
    }

}
