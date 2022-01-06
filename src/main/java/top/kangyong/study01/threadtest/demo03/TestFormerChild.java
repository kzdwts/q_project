package top.kangyong.study01.threadtest.demo03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/8/31 17:51
 * @version: v1.0
 */
public class TestFormerChild {

    public static void main(String[] args) {
        Framer framer = new Framer();
        Child child = new Child();

        framer.start();
        child.start();
    }
}
