package demo;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        Class clazz = Class.forName("demo.Elphant");

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
        Class clazz = Class.forName("demo.Elphant");

        // 获取方法 自己所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    @Test
    public void test03() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 获取类
        Class clazz = Class.forName("demo.Elphant");

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
        setHeight.invoke(elphant,555.55);
        System.out.println("反射更新了对象的值：" + elphant);
        watch.stop();

        watch.start("task2");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(elphant, "gray brownness");
        System.out.println("反射更新了对象的值：" + elphant);
        watch.stop();

        System.out.println("StopWatch结果：" + watch.prettyPrint());
    }

}
