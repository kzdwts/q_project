package top.kangyong.study02.design.pattern.creatormode.singleton.demo8;

import java.lang.reflect.Constructor;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/8/13
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws Exception {
        // 获取Singleton字节码对象
        Class clazz = Singleton.class;
        // 获取无参构造方法对象
        Constructor cons = clazz.getDeclaredConstructor();
        // 取消访问检查
        cons.setAccessible(true);

        // 创建singleton对象
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 == s2);  // false
        // 如果返回true，说明没有破坏单例模式
        // 如果是false，说明破坏了单例模式

    }
}
