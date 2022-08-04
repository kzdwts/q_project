package top.kangyong.study02.design.pattern.creatormode.singleton.demo2;

/**
 * 单例模式 饿汉式 静态代码块
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/4
 * @since 1.0.0
 */
public class Singleton {

    /**
     * 构造一个私有方法
     *
     * @author Kang Yong
     * @date 2022/8/4
     */
    private Singleton() {

    }

    // 成员变量
    private static Singleton instance;

    /**
     * 静态块实例化对象
     * @author Kang Yong
     * @date 2022/8/4
     */
    static {
        instance = new Singleton();
    }

    /**
     * 提供对外的访问接口
     *
     * @author Kang Yong
     * @date 2022/8/4
     */
    public static Singleton getInstance() {
        return instance;
    }

}
