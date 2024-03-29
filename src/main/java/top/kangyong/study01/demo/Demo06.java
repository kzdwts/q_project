package top.kangyong.study01.demo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/8/1 10:32
 * @version: v1.0
 */
public class Demo06 {

    @Test
    public void test01() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

    }

    @Test
    public void test02() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void test03() {
        Integer num = 1000000;
        if (num == 1000000) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Integer b = 1000000;
        System.out.println(num == b);
    }

    @Test
    public void test04() {
        System.out.println(0 / 1);
        System.out.println(1 / 0);
    }

    @Test
    public void test05() {
        String dd = "98.3%";
        // String dStr = dd.substring(0, dd.length() - 1);
        String dStr = dd.replace("%", "");
        System.out.println(dStr);
    }

    @Test
    public void test06() {
        int num = 59 + 62 + 0 + 50 + 15 + 8 + 12 + 45 + 22 + 51 + 14 + 80 + 42 + 15 + 41 + 62 + 19 + 38 + 68 + 0 + 10 + 68 + 30 + 20 + 30 + 11 + 34 + 40 + 27 + 35 + 12 + 39 + 22 + 57 + 7 + 143 + 47 + 0 + 107 + 75 + 66 + 23 + 18 + 3 + 27 + 13 + 13 + 70 + 11 + 60 + 37 + 0 + 27 + 20 + 55 + 54 + 25 + 88 + 37 + 115;
        System.out.println(num);
    }

    @Test
    public void test07() {
        Long num1 = 1L;
        Integer num2 = 2;

    }

    @Test
    public void test08() {
    }


    public Map<String, String> getAreaDataMap() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("ARHF83", "2020/7/13 0:00");
        resultMap.put("ARHF53", "2018/12/23 0:00");
        resultMap.put("ARHF85", "2020/7/1 0:00");
        resultMap.put("ARHF56", "2019/1/12 0:00");
        resultMap.put("ARHF55", "2019/5/10 0:00");
        resultMap.put("ARHF70", "2020/1/17 0:00");
        resultMap.put("ARHF74", "2020/1/17 0:00");
        resultMap.put("ARHF32", "2016/1/13 0:00");
        resultMap.put("ARHF97", "2015/12/26 0:00");
        resultMap.put("ARHF25", "2017/7/13 0:00");
        resultMap.put("ARHF50", "2018/9/9 0:00");
        resultMap.put("ARHF40", "2017/6/17 0:00");
        resultMap.put("ARHF01", "2006/7/20 0:00");
        resultMap.put("ARHF41", "2017/7/1 0:00");
        resultMap.put("ARHF64", "2019/5/8 0:00");
        resultMap.put("ARHF42", "2017/6/28 0:00");
        resultMap.put("ARHF48", "2018/6/29 0:00");
        resultMap.put("ARHF79", "2020/7/1 0:00");
        resultMap.put("ARHF87", "2018/6/2 0:00");
        resultMap.put("ARHF43", "2018/1/19 0:00");
        resultMap.put("ARHF37", "2016/12/12 0:00");
        resultMap.put("ARHF28", "2014/9/13 0:00");
        resultMap.put("ARHF30", "2015/7/18 0:00");
        resultMap.put("ARHF45", "2018/7/1 0:00");
        resultMap.put("ARHF46", "2018/6/28 0:00");
        resultMap.put("ARHF82", "2020/6/27 0:00");
        resultMap.put("ARHF26", "2014/7/3 0:00");
        resultMap.put("ARHF62", "2019/6/11 0:00");
        resultMap.put("ARHF22", "2012/6/1 0:00");
        resultMap.put("ARHF47", "2018/7/1 0:00");
        resultMap.put("ARHF16", "2011/12/9 0:00");
        resultMap.put("ARHF33", "2016/7/1 0:00");
        resultMap.put("ARHF80", "2020/7/1 0:00");
        resultMap.put("ARHF19", "2012/6/10 0:00");
        resultMap.put("ARHF49", "2019/1/17 0:00");
        resultMap.put("ARHF54", "2019/3/1 0:00");
        resultMap.put("ARHF14", "2010/7/5 0:00");
        resultMap.put("ARHF08", "2008/1/28 0:00");
        resultMap.put("ARHF65", "2019/9/1 0:00");
        resultMap.put("ARHF75", "2020/1/30 0:00");
        resultMap.put("ARHF96", "2020/5/1 0:00");
        resultMap.put("ARHF34", "2016/6/28 0:00");
        resultMap.put("ARHF18", "2012/1/9 0:00");
        resultMap.put("ARHF52", "2019/1/12 0:00");
        resultMap.put("ARHF78", "2020/1/30 0:00");
        resultMap.put("ARHF66", "2019/6/10 0:00");
        resultMap.put("ARHF91", "2020/7/6 0:00");
        resultMap.put("ARHF76", "2020/1/4 0:00");
        resultMap.put("ARHF84", "2012/10/17 0:00");
        resultMap.put("ARHF24", "2012/9/16 0:00");
        resultMap.put("ARHF71", "2019/9/22 0:00");
        resultMap.put("ARHF77", "2020/1/17 0:00");
        resultMap.put("ARHF69", "2019/9/7 0:00");
        resultMap.put("ARHF68", "2020/1/4 0:00");
        resultMap.put("ARHF67", "2019/11/23 0:00");
        resultMap.put("ARHF59", "2019/6/20 0:00");
        resultMap.put("ARHF51", "2019/1/12 0:00");
        resultMap.put("ARHF36", "2016/9/10 0:00");
        resultMap.put("ARHF44", "2018/1/30 0:00");
        resultMap.put("ARHF38", "2017/6/26 0:00");
        resultMap.put("ARHF31", "2015/12/12 0:00");
        resultMap.put("ARHF23", "2012/9/11 0:00");
        resultMap.put("ARHF39", "2017/7/10 0:00");
        resultMap.put("ARHF57", "2019/5/10 0:00");
        resultMap.put("ARHF63", "2019/5/18 0:00");
        resultMap.put("ARHF86", "2020/6/27 0:00");
        resultMap.put("ARHF35", "2016/6/30 0:00");
        resultMap.put("ARHF27", "2014/7/16 0:00");
        resultMap.put("ARHF29", "2015/2/8 0:00");

        return resultMap;
    }


    @Test
    public void test11() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
    }

    @Test
    public void test12() {
        String phone = "17755242819";
        System.out.println(phone.substring(0, 3) + "***" + phone.substring(7));
    }

    @Test
    public void test13() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String oldDateStr = "2022-10-25 23:55:00";
        Date oldData = sdf.parse(oldDateStr);
        Date date = sdf.parse(oldDateStr);
        System.out.println(date);
        int i = date.compareTo(oldData);
        System.out.println(i);
    }

    /**
     * 20210128
     */
    @Test
    public void test14() {

    }


    @Test
    public void test15() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String oldDateStr = "2021-08-03 23:55:00";
        Date oldData = sdf.parse(oldDateStr);
        Date date = new Date();
        System.out.println(date);
        System.out.println(oldData);
        int i = date.compareTo(oldData);
        System.out.println(i);
    }

    @Test
    public void getDate() {
        Date dd = new Date();
        System.out.println(dd);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        TimeZone timeZone = sdf.getTimeZone();
        System.out.println(timeZone);
        System.out.println(sdf.format(dd));
    }

    @Test
    public void testGetEmail() {
        String email = "kangyong_wts@sina.com";
        email = email.split("@")[0];
        System.out.println(email);
    }

    @Test
    public void testGetDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse("2021-08-15 08:00:00.000");
        System.out.println(startDate);

        Date endDate = sdf.parse("2021-08-18 23:59:00.000");
        System.out.println(endDate);
    }

}
