package top.kangyong.study01.demo;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/10/29 11:46
 * @version: v1.0
 */
public class Demo07 {

    @Test
    public void test01() throws ClassNotFoundException {
        // 获取类
        Class clazz = Class.forName("top.kangyong.study01.demo.Elphant");

        // 获取公有方法，父类公有方法
        Method[] methods = clazz.getMethods();
        System.out.println("====自己的公有方法和父类的公有方法===");
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    @Test
    public void test02() throws ClassNotFoundException {
        // 获取类
        Class clazz = Class.forName("top.kangyong.study01.demo.Elphant");

        // 获取方法 自己所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    @Test
    public void test03() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 获取类
        Class clazz = Class.forName("top.kangyong.study01.demo.Elphant");

        // 生成一个对象
        Constructor c = clazz.getConstructor(Double.class, Double.class, String.class);
        Elphant elphant = (Elphant) c.newInstance(2000.5, 2.3, "white");

        // 获取方法
        Method m1 = clazz.getMethod("getWeight");
        Double o = (Double) m1.invoke(elphant);
        System.out.println(o);
    }

    @Test
    public void test04() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Elphant elphant = new Elphant(2345.6, 4.32, "red");
        System.out.println("原始对象数据：" + elphant);

        StopWatch watch = new StopWatch();
        watch.start("task1");
        Class clazz = elphant.getClass();
        Method setHeight = clazz.getMethod("setHeight", Double.class);
        setHeight.invoke(elphant, 555.55);
        System.out.println("反射更新了对象的值：" + elphant);
        watch.stop();

        watch.start("task2");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(elphant, "gray brownness");
        System.out.println("反射更新了对象的值：" + elphant);
        watch.stop();

        System.out.println("StopWatch结果：" + watch.prettyPrint());
    }

    @Test
    public void test05() {
        int id = 13;
        System.out.println(id == 11 ? "小学" : id == 12 ? "初中" : "高中");
    }

    @Test
    public void test06() {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        joiner.add("a").add("b").add("c");
        String str = joiner.toString();
        System.out.println(str);
    }

    @Test
    public void test07() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
//        numbers.forEach(System.out::println);
        String commaSeparatedNumbers = numbers.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
        System.out.println(commaSeparatedNumbers);
    }

    @Test
    public void test08() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.forEach(System.out::println);
        String message = String.join("-", list);
        System.out.println("拼接后的数据为：" + message);

        List<String> list2 = null;
        list.addAll(list2);
        list.forEach(System.out::println);
    }

    @Test
    public void test09() {
        Long num1 = 9999999L;
        long no1 = 9999999;
        Long num2 = 9999999L;
        System.out.println("num1 & no1 " + (num1 == no1));
        System.out.println("num1 & num2 " + (num1.equals(num2)));
        System.out.println("num1 & no1 " + (num1.equals(no1)));
    }



}
