package top.kangyong.study02.design.pattern.creatormode.singleton.demo7;

import java.io.Serializable;

/**
 * 单例模式 破坏单例模式
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/10
 * @since 1.0.0
 */
public class Singleton implements Serializable {

    private Singleton() {
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
     *
     * @return
     */
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
