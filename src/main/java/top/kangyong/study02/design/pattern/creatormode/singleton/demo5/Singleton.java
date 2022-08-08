package top.kangyong.study02.design.pattern.creatormode.singleton.demo5;

/**
 * 单例模式 懒汉式 静态内部类方式(优秀的单例模式，是开源项目中比较常用的一种单例模式)
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/8
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    /**
     * 定义一个静态内部类
     */
    private static class SingletonHolder {
        // 在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 提供公共的访问方式
     *
     * @return {@link Singleton}
     * @author Kang Yong
     * @date 2022/8/8
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
