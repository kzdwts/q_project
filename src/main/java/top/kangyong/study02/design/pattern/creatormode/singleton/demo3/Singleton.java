package top.kangyong.study02.design.pattern.creatormode.singleton.demo3;

/**
 * 单例模式 懒汉式
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/7
 * @since 1.0.0
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        instance = new Singleton();
        return instance;
    }

}
