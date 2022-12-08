package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.math.MathUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Test
    public void testPlusMonth() {
        LocalDateTime now = LocalDateTime.now();
        Date date = DateUtil.plusMonth(now, 3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

    @Test
    public void testAddDay() {
        DateTime offset = cn.hutool.core.date.DateUtil.offset(new Date(), DateField.DAY_OF_YEAR, 24);
        System.out.println(offset);
    }

    @Test
    public void testSubDay() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime d1 = localDateTime.plusDays(-1);
//        System.out.println(d1);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate d1 = localDate.plusDays(-10);
        LocalDate d2 = localDate.plusDays(-12);
        System.out.println(d1);
        System.out.println(d2);

    }

}
