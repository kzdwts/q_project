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

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            // 如果是多线程，线程1执行到这里，线程2获取到了cpu时间片，线程2执行，就会两个对象不一样，所以要加锁处理
            instance = new Singleton();
        }
        return instance;
    }

}
