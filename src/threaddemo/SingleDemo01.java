package threaddemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 单例模式：饿汉式
 * @author: kangyong
 * @date: 2019/5/10 11:10
 * @version: v1.0
 */
public class SingleDemo01 {

    private static SingleDemo01 s1 = new SingleDemo01();

    private SingleDemo01() {
        // 提供私有化的构造方法，外界就不能创建实例了
    }

    /**
     * 获取实例
     * @return
     */
    public static SingleDemo01 getS1() {
        return s1;
    }
}
