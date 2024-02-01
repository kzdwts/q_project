package top.kangyong.study02.mathcode;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试
 *
 * @author Kang Yong
 * @date 2022/3/31
 * @since 1.0.0
 */
public class MathTest {

    @Test
    public void bigDecimalTest01() {
        BigDecimal b1 = new BigDecimal(100.00);
        BigDecimal b2 = new BigDecimal(-111.00);
        BigDecimal b3 = new BigDecimal(200.00);
        BigDecimal b4 = new BigDecimal(0.00);

        System.out.println(b1.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b2.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b3.compareTo(BigDecimal.ZERO) > 0);
        System.out.println(b4.compareTo(BigDecimal.ZERO) <= 0);

    }

    @Test
    public void bigDecimalTest02() {
        BigDecimal b1 = new BigDecimal("106.12");
        BigDecimal b2 = new BigDecimal("167.8");
        BigDecimal b3 = new BigDecimal("106.12");
        BigDecimal b4 = new BigDecimal("1.82");

        List<BigDecimal> bList = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        BigDecimal max = Collections.max(bList);
        BigDecimal min = Collections.min(bList);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("===华丽的分割线===");

        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
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


    /**
     * Long 比较大小
     *
     * @author Kang Yong
     * @date 2022/5/12
     */
    @Test
    public void longCompareToTest01() {
        Long a = 78901L;
        Long b = 78901L;
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        // 结论：a.compareTo(b)
        // a > b → 结果是 1
        // a < b → 结果是 -1
        // a == b → 结果是0
    }


    @Test
    public void integerEquals() {
        Integer a = 1203670;
        Integer b = 1203671;

        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a > b);
        System.out.println(a.compareTo(b));
    }

    /**
     * 测试 ThreadLocalRandom
     *
     * @author Kang Yong
     * @date 2022/6/23
     */
    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            int num = ThreadLocalRandom.current().nextInt(2, 10);
            System.out.println(num);
        }
    }

    @Test
    public void testBigDecimalToInt() {
        BigDecimal b1 = new BigDecimal(18.99);
        System.out.println(b1);

        int i1 = b1.intValue();
        System.out.println(i1);
    }

    /**
     * 功能: 测试Math取反
     *
     * @author Kang Yong
     * @date 2022/12/8
     */
    @Test
    public void testQufan() {
        int num1 = Math.negateExact(10);
        System.out.println(num1);

        int num2 = Math.negateExact(1111);
        System.out.println(num2);

        System.out.println(Math.negateExact(num2));
    }

    /**
     * 测试list.reduce
     *
     * @author Kang Yong
     * @date 2023/1/31
     */
    @Test
    public void testListReduce() {
        List<BigDecimal> numList = new ArrayList<>();
        numList.add(new BigDecimal(0.10));
        numList.add(new BigDecimal(1.10));
        numList.add(new BigDecimal(0.30));

        BigDecimal result = numList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
    }

    /**
     * 测试Math.ceil() 向上取整
     *
     * @author Kang Yong
     * @date 2023/4/6
     */
    @Test
    public void testMathCeil() {
        Integer a = 19;
        Integer b = 3;

        double ceil = Math.ceil((a * 1.0 / b));
        long round = Math.round((a * 1.0 / b));
        System.out.println("round = " + round);

        System.out.println(ceil);

        int index = (int) Math.ceil(Math.ceil((a * 1.0 / b)));
        System.out.println("index = " + index);
    }

    /**
     * 测试除法
     */
    @Test
    public void testDiv() {
        Integer a = 0;
        Integer b = 1;

        BigDecimal div = NumberUtil.div(a, b);
        System.out.println(div);

//        BigDecimal div1 = NumberUtil.div(b, a);
//        System.out.println("div1 = " + div1);

//        Integer c = 0;
//        BigDecimal div2 = NumberUtil.div(a, c);
//        System.out.println("div2 = " + div2);
    }

    @Test
    public void testBigDecimalSetScale() {
        BigDecimal b1 = new BigDecimal(0.00);
        String b1Str = b1.setScale(2, RoundingMode.HALF_UP) + "%";
        System.out.println("b1Str = " + b1Str);


        BigDecimal b2 = new BigDecimal(1.2345);
        String b2Str = b2.setScale(2, RoundingMode.HALF_UP) + "%";
        System.out.println("b2Str = " + b2Str);

        BigDecimal b3 = new BigDecimal(100);
        String b3Str = b3.setScale(2, RoundingMode.HALF_UP) + "%";
        System.out.println("b3Str = " + b3Str);
    }


}
