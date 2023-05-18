package top.kangyong.study02.basetypecode;

import org.junit.Test;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/8/17
 * @since 1.0.0
 */
public class IntDemo {

    @Test
    public void demo01() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void demo02() {
        Long timestamp = System.currentTimeMillis() / 1000;
        System.out.println("timestamp = " + timestamp);
    }

}
