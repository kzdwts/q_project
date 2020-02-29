package test01;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/12/2 15:20
 * @version: v1.0
 */
public class Demo04 {

    @Test
    public void test01() {
        String str = "start";
        StringBuilder sb = new StringBuilder("start");
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            str = str + " Hello";
        }
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            sb.append(" Hello");
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(sb.toString());
        System.out.println(str);
    }

}
