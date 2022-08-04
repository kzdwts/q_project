package top.kangyong.study02.design.pattern.creatormode.singleton.demo1;

/**
 * 客户端
 *
 * @author Kang Yong
 * @date 2022/8/4
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("SUCCESS");
    }

}
