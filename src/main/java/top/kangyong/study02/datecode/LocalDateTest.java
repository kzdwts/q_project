package top.kangyong.study02.datecode;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * java8全新的日期和时间API LocalDate
 *
 * @author Kang Yong
 * @date 2022/1/18
 * @since 1.0.0
 */
public class LocalDateTest {

    /**
     * 创建LocalDate
     */
    @Test
    public void demo01() {
        // 获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // 构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        System.out.println(localDate1);
    }

    /**
     * LocalDate方法
     */
    @Test
    public void demo02() {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int year2 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month2 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth = localDate.getDayOfMonth();
        int dayOfMonth2 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek2 = localDate.get(ChronoField.DAY_OF_WEEK);

        System.out.println(year);
        System.out.println(year2);
        System.out.println(month);
        System.out.println(month2);
        System.out.println(dayOfMonth);
        System.out.println(dayOfMonth2);
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek2);
    }

    @Test
    public void demo03() {
        LocalDate localDate = LocalDate.now();
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(localDate);
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void getLastMonth() {
        String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("currentMonth = " + currentMonth);

        String lastMonth = LocalDate.now().plusMonths(-1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("lastMonth = " + lastMonth);

        String aMonth = LocalDate.parse("2023-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("aMonth = " + aMonth);

        String bMonth = LocalDate.parse("2023-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusMonths(-1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("bMonth = " + bMonth);
    }

    @Test
    public void getCurrentMonth() {
        Month month = LocalDate.now().getMonth();
        int value = month.getValue();
        System.out.println("value = " + value);
    }

    /**
     * 计算两个时间相差的月份
     */
    @Test
    public void testMonthBetween() {
        LocalDate date2 = LocalDate.of(2022, 1, 1);
        LocalDate date1 = LocalDate.of(2022, 6, 1);

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        System.out.println("两个时间相差的月份： " + monthsBetween);
    }
}
