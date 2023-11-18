package top.kangyong.study02.basetypecode;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import java.math.BigDecimal;

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

    @Test
    public void demo03() {
        int year = 2024;
        int y2 = 2024;

        System.out.println("(year == y2) = " + (year == y2));
    }

    @Test
    public void test04() {
        BigDecimal b1 = new BigDecimal(20);
        BigDecimal b2 = new BigDecimal(200);
        BigDecimal result = NumberUtil.div(b1, b2, 2);
        System.out.println("result = " + result);
    }

}
