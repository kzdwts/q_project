package top.kangyong.study02.mathcode;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试
 *
 * @author Kang Yong
 * @date 2022/3/31
 * @since 1.0.0
 */
public class MathTest {

    @Test
    public void test01() {
        BigDecimal b1 = new BigDecimal(100.00);
        BigDecimal b2 = new BigDecimal(-111.00);
        BigDecimal b3 = new BigDecimal(200.00);
        BigDecimal b4 = new BigDecimal(0.00);

        System.out.println(b1.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b2.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b3.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b4.compareTo(BigDecimal.ZERO) <= 0);

    }

    /**
     * Integer 比较大小
     *
     * @author Kang Yong
     * @date 2022/5/12
     */
    @Test
    public void integerCompareToTest01() {
        Integer a = 78901;
        Integer b = 7890;
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        // 结论：a.compareTo(b)
        // a > b → 结果是 1
        // a < b → 结果是 -1
        // a == b → 结果是0

    }
}
