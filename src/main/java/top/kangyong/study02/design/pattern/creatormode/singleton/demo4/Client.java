package top.kangyong.study02.design.pattern.creatormode.singleton.demo4;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/8/8
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

        System.out.println(instance);
        System.out.println(instance2);

    }
}
