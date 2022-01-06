package top.kangyong.study01.demo;

import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/11/18 13:43
 * @version: v1.0
 */
public class Demo08 {

    /**
     * 测试集合toArray方法
     */
    @Test
    public void testToArray() {
        List<String> list = new ArrayList<>(2);
        list.add("zhang");
        list.add("jinfeng");

//        String[] strs = new String[]{};
        String[] strs = new String[list.size()];
        strs = list.toArray(strs);
        for (String str : strs) {
            System.out.println(str);
        }
    }

    @Test
    public void testDemo01() {
        List<String> list = new ArrayList<>();
        list.add("王丽丽");
        list.add("王悦悦");
        list.add("暴风");
        list.add("张进凤");
        list.add("陆智航");
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("list.size()=" + list.size());
        System.out.println("=========iterator循环==========");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }

        System.out.println("========foreach循环===========");
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("=======直接打印============");
        list.forEach(System.out::println);
    }

    /**
     * 集合定义
     */
    @Test
    public void testDemo02() {
        HashMap<String, Object> map = new HashMap<>(16);
        ArrayList<Elphant> elphants = new ArrayList(10);
    }

    /**
     * hashMap测试
     */
    @Test
    public void testDemo03HashMap() {
        Map<Integer, Person> personMap = new HashMap<>(16);
        System.out.println("map长度=" + personMap.size());

        long millis = System.currentTimeMillis();
        for (int i = 0; i < 1024; i++) {
            personMap.put(i + 1, new Person("王丽丽", i + 1));
        }
        System.out.println(System.currentTimeMillis() - millis);
        personMap.forEach((k, v) -> {
            System.out.println("第 " + k + " 号员工," + "信息：" + v);
        });
        System.out.println("map长度=" + personMap.size());
    }

    /**
     * map遍历
     */
    @Test
    public void testDemo04() {
        // 装数据
        Map<Integer, Person> personMap = new HashMap<>(16);
        System.out.println("map长度=" + personMap.size());


        for (int i = 0; i < 1024; i++) {
            personMap.put(i + 1, new Person("王丽丽", i + 1));
        }

        long m1 = System.currentTimeMillis();
        // keySet方式遍历
        Set<Integer> integers = personMap.keySet();
        for (Integer key : integers) {
            System.out.println(key + personMap.get(key).toString());
        }
        long m2 = System.currentTimeMillis();
        System.out.println("===============ketSet结束,运行时间" + (m2-m1));

        // entrySet遍历
        Set<Map.Entry<Integer, Person>> entries = personMap.entrySet();
        for (Map.Entry<Integer, Person> e :
                entries) {
            System.out.println("第 " + e.getKey() + " 号员工," + "信息：" + e.getValue());
        }
        System.out.println("===============entrySet结束");

        // foreach遍历
        personMap.forEach((k, v) -> {
            System.out.println("第 " + k + " 号员工," + "信息：" + v);
        });
        System.out.println("===============foreach结束");

    }

    @Test
    public void testDemo05() {
        String name = "i like wanglili";

        String replace = name.replace("wanglili", "lizimu");
        System.out.println(replace);
        System.out.println(name);
    }

    @Test
    public void testDemo06() {
        List<String> list = new ArrayList<String>(Arrays.asList("100","288","300"));
        Integer num = 100;
        String numStr = "100";
        boolean flag = list.contains(num.toString());
        System.out.println(flag);
    }

    @Test
    public void testDemou07() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Thread.sleep(1000);
        System.out.println(date1.compareTo(new Date()));
    }

    @Test
    public void testDemo08() {
        List<String> list = new ArrayList<>(3);
        list.add("王丽丽");
        list.add("储小姣");
        list.add("鲍风");
        list.add("张");
        list.forEach(System.out::println);

    }

}
