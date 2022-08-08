package top.kangyong.study02.design.pattern.creatormode.singleton.demo4;

/**
 * 单例模式 懒汉式 双重检查锁
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/8
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 构造私有方法
     */
    private Singleton() {

    }

    private static Singleton instance;

    public static Singleton getInstance() {
        // 第一次判断，如果不为null，不需要抢占锁，直接返回对象
        if (instance == null) {
            // 第二次判断
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
