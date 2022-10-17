package top.kangyong.study02.datecode;

import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * date util test
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
public class DateUtilTest {

    @Test
    public void testGetDayListOfMonth() {
        List<String> list = DateUtil.getDayListOfMonth();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetDayListOfMonth2() {
        List<String> list = DateUtil.getDayListOfMonth(new Date());
        list.forEach(System.out::println);
    }

    @Test
    public void testgetDateHours() {
        List<String> hourList = DateUtil.getDateHours(7, 19);
        hourList.forEach(System.out::println);
    }

    @Test
    public void testGetLastMonthDate() {
        List<String> monthList = DateUtil.getLastMonthDate(4);
        monthList.forEach(System.out::println);
    }

}
