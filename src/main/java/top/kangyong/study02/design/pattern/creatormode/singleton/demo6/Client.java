package top.kangyong.study02.design.pattern.creatormode.singleton.demo6;

/**
 * 单例模式 饿汉式 枚举实现方式（不考虑浪费内存空间的情况下，首选枚举方式。但是肯定要考虑呀，，，）
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/9
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);
    }
}
