package top.kangyong.study02.design.pattern.creatormode.singleton.demo8;

/**
 * 单例模式
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/13
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 私有构造
     */
    private Singleton() {

    }

    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }

    /**
     * 公共方法
     *
     * @return
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
