package top.kangyong.study01.design.pattern.singleton.dcl;

/**
 * 双检锁/双重校验锁
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
