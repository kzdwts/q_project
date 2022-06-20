package top.kangyong.study01.design.pattern.singleton.hungry;

/**
 * 饿汉式
 * 是否多线程安全：是
 * <p>
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/15
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 直接创建
     */
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
