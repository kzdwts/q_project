package top.kangyong.study02.mathcode;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.db.ds.simple.SimpleDataSource;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import top.kangyong.study01.design.pattern.mediator.User;
import top.kangyong.study02.model.UserDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

        BigDecimal div1 = NumberUtil.div(b, a);
        System.out.println("div1 = " + div1);

//        Integer c = 0;
//        BigDecimal div2 = NumberUtil.div(a, c);
//        System.out.println("div2 = " + div2);
    }

    /**
     * 测试BigDecimal ==
     */
    @Test
    public void testBigDecimalCalc() {
        BigDecimal b1 = new BigDecimal(0.00);
        if (b1.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("等于");
        }
        System.out.println("(b1.compareTo(BigDecimal.ZERO) == 0) = " + (b1.compareTo(BigDecimal.ZERO) == 0));
        System.out.println("Over");
    }

    /**
     * 测试BigDecimal toEngineeringString
     */
    @Test
    public void testBigDecimalToEngineeringString() {
        String taxRate = "0.11";
        BigDecimal rate = NumberUtil.div(new BigDecimal(taxRate), 100);
        String engineeringString = rate.toEngineeringString();
        System.out.println("engineeringString = " + engineeringString);

        String str = rate.toString();
        System.out.println("str = " + str);

        String str2 = rate.setScale(4, RoundingMode.HALF_UP).toString();
        System.out.println("str2 = " + str2);
    }

    @Test
    public void testBigDecimal2Point() {
        BigDecimal b1 = new BigDecimal("0.98");
        System.out.println("b1 = " + b1);
        BigDecimal t1 = b1.setScale(2, RoundingMode.DOWN);
        System.out.println("t1 = " + t1);

        BigDecimal b2 = new BigDecimal("0.9803");
        System.out.println("b2 = " + b2);
        BigDecimal t2 = b2.setScale(2, RoundingMode.DOWN);
        System.out.println("t2 = " + t2);

        BigDecimal b3 = new BigDecimal("0.9899");
        System.out.println("b3 = " + b3);
        BigDecimal t3 = b3.setScale(2, RoundingMode.DOWN);
        System.out.println("t3 = " + t3);

        BigDecimal b4 = new BigDecimal("100");
        System.out.println("b4 = " + b4);
        BigDecimal t4 = b4.setScale(2, RoundingMode.DOWN);
        System.out.println("t4 = " + t4);

        BigDecimal b5 = new BigDecimal("98.1");
        System.out.println("b5 = " + b5);
        BigDecimal t5 = b5.setScale(2, RoundingMode.DOWN);
        System.out.println("t5 = " + t5);
    }

    @Test
    public void testBigDecimalToString() {
        String taxRate = "0.11";
        String taxRatePercent = NumberUtil.mul(new BigDecimal(taxRate), 100).toString();
        System.out.println("taxRatePercent = " + taxRatePercent);
        System.out.println("JSON.toJSONString(taxRatePercent) = " + JSON.toJSONString(taxRatePercent));

        String percent2 = NumberUtil.mul(new BigDecimal(taxRate), 100).setScale(0, RoundingMode.HALF_UP).toString();
        System.out.println("percent2 = " + percent2);
        System.out.println("JSON.toJSONString(percent2) = " + JSON.toJSONString(percent2));
    }

    @Test
    public void testBigDecimalSubstringToString() {
        String taxRate = "0.11%";
        String substring = taxRate.substring(0, taxRate.length() - 1);
        System.out.println("substring = " + substring);
        String taxRatePercent = NumberUtil.mul(new BigDecimal(substring), 100).toString();
        System.out.println("taxRatePercent = " + taxRatePercent);
        System.out.println("JSON.toJSONString(taxRatePercent) = " + JSON.toJSONString(taxRatePercent));

        String percent2 = NumberUtil.mul(new BigDecimal(substring), 100).setScale(0, RoundingMode.HALF_UP).toString();
        System.out.println("percent2 = " + percent2);
        System.out.println("JSON.toJSONString(percent2) = " + JSON.toJSONString(percent2));
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

    @Test
    public void testmultiply() throws ParseException {
        String str = new BigDecimal(0.1).multiply(new BigDecimal(60)).toString();
        System.out.println(str);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println("timestamp = " + timestamp);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2024-05-11 20:02:19");
        Date date2 = sdf.parse("2023-11-27 18:22:03");
        List<UseTimeDto> dateList = new ArrayList<>();
        dateList.add(new UseTimeDto("屋大维", date1));
        dateList.add(new UseTimeDto("张舒", date2));
        System.out.println("JSON.toJSONString(dateList) = " + JSON.toJSONString(dateList));

        Date dateResult = dateList.stream().map(UseTimeDto::getBir).distinct().min(Date::compareTo).orElse(null);
        System.out.println(sdf.format(dateResult));
    }

    /**
     * sub是减法
     * div是除法
     *
     * @author Kang Yong
     * @date 2024/8/1
     */
    @Test
    public void testSub() {
        Integer a = 1;
        BigDecimal b = new BigDecimal(13);
        BigDecimal div = NumberUtil.div(b, 100);
        System.out.println("div = " + div);

        BigDecimal sub = NumberUtil.sub(1, div);
        System.out.println("sub = " + sub);
    }


    public static List<Integer> convertBit(int sum) {
        List<Integer> nums = new ArrayList<>();
        int powerOfTwo = 1;

        while (sum > 0) {
            if ((sum & 1) == 1) {
                nums.add(powerOfTwo);
            }
            sum >>= 1;
            powerOfTwo <<= 1;
        }

        return nums;
    }

    @Test
    public void testBit() {
        List<Integer> nums = convertBit(3);
        System.out.println(nums);
    }


}
