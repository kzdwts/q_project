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

    private static boolean flag = false;

    /**
     * 私有构造
     */
    private Singleton() {

        synchronized (Singleton.class) {

            // 如果flag是true，说明非第一次访问，直接抛出一个异常；如果是false，说明是第一次访问
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }

            // 将flag的值设置为true
            flag = true;
        }
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 公共方法
     *
     * @return
     */
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
