package top.kangyong.study01.design.pattern.singleton.dcl;

/**
 * 双检锁/双重校验锁
 * 是否多线程安全：是
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能
 * <p>
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/16
 * @since 1.0.0
 */
public class SingletonDCL {

    private volatile static SingletonDCL singleton;

    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (singleton == null) {
            synchronized (SingletonDCL.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }

        return singleton;
    }
}
