package top.kangyong.study01.design.pattern.singleton.lazy;

/**
 * 懒汉式，线程安全
 * <p>
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/14
 * @since 1.0.0
 */
public class SingletonSafe {

    private static SingletonSafe instance;

    private SingletonSafe() {
    }

    /**
     * 获取实例对象，非线程安全
     *
     * @return {@link SingletonSafe}
     * @author Kang Yong
     * @date 2022/6/14
     */
    public static synchronized SingletonSafe getInstance() {
        if (instance == null) {
            instance = new SingletonSafe();
        }
        return instance;
    }
}
