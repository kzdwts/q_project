package top.kangyong.study02.design.pattern.creatormode.singleton.demo1;

/**
 * 单例模式：饿汉式 静态成员变量
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/3
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 构造一个私有方法
     *
     * @author Kang Yong
     * @date 2022/8/3
     */
    private Singleton() {

    }

    // 在本类中创建一个本类对象
    private static Singleton instance = new Singleton();

    /**
     * 提供一个公共的访问方式，让外界可以获取该对象
     *
     * @return {@link Singleton}
     * @author Kang Yong
     * @date 2022/8/3
     */
    public static Singleton getInstance() {
        return instance;
    }
}
