package top.kangyong.study01.design.pattern.singleton;

/**
 * 单例对象
 * <p>
 * 单例模式(饿汉式)
 *
 * @author Kang Yong
 * @date 2022/6/13
 * @since 1.0.0
 */
public class SingletonObject {

    private static SingletonObject instance = new SingletonObject();

    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("===showMessage");
    }
}
