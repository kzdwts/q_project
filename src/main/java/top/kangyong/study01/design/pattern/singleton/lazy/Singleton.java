package top.kangyong.study01.design.pattern.singleton.lazy;

/**
 * 懒汉式，线程不安全
 * 是否多线程安全：否
 * <p>
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/14
 * @since 1.0.0
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 获取实例对象，非线程安全
     *
     * @return {@link Singleton}
     * @author Kang Yong
     * @date 2022/6/14
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
