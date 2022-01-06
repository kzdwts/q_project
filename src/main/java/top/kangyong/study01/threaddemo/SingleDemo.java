package top.kangyong.study01.threaddemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 单例模式
 * @author: kangyong
 * @date: 2019/5/10 11:18
 * @version: v1.0
 */
public class SingleDemo {

    public static void main(String[] args) {
        SingleDemo01 s1 = SingleDemo01.getS1();
        SingleDemo02 s2 = SingleDemo02.getS2();

        SingleDemo01 s3 = SingleDemo01.getS1();
        SingleDemo02 s4 = SingleDemo02.getS2();

        System.out.println(s1 == s3);
        System.out.println(s2 == s4);

    }

}
