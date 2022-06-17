package top.kangyong.study01.design.pattern.singleton.register;

/**
 * 登记式/静态内部类
 * <p>
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/17
 * @since 1.0.0
 */
public class SingletonRegister {

    private static class SingletonHolder {
        private static final SingletonRegister INSTANCE = new SingletonRegister();
    }

    private SingletonRegister() {

    }

    private static final SingletonRegister getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
