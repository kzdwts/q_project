package top.kangyong.study02.design.pattern.creatormode.singleton.demo7;

/**
 * 单例模式 破坏单例模式
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/10
 * @since 1.0.0
 */
public class Singleton {

    private Singleton() {
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
