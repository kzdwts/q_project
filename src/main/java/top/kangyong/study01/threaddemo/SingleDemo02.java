package top.kangyong.study01.threaddemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 单例模式：懒汉式
 * @author: kangyong
 * @date: 2019/5/10 11:12
 * @version: v1.0
 */
public class SingleDemo02 {

    private static SingleDemo02 s2;

    private SingleDemo02() {
        // 构造方法私有化
    }

    public static SingleDemo02 getS2() {
        if (s2 == null) {
            s2 = new SingleDemo02();
        }
        return s2;
    }
}
