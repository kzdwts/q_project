package top.kangyong.study02.datecode;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
        LocalDate localDate1 = LocalDate.of(1995, 5, 17);
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
        LocalDate date2 = LocalDate.of(2022, 8, 1);
        LocalDate date1 = LocalDate.of(2022, 11, 1);

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        System.out.println("两个时间相差的月份： " + monthsBetween);

        long monthsBetween2 = ChronoUnit.MONTHS.between(date2, date1);
        System.out.println("两个时间相差的月份： " + monthsBetween2);
    }

    @Test
    public void testGetFrontDate() {
        Integer n = 3;
        String formatDate = LocalDate.now().minusDays(n).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("formatDate = " + formatDate);
    }

    /**
     * 测试LocalDate.plusYears
     *
     * @author Kang Yong
     * @date 2024/6/19
     */
    @Test
    public void testPlusYear() throws ParseException {
        String date18Str = "2022-06-18";
        String date19Str = "2022-06-19";
        Date date18 = new SimpleDateFormat("yyyy-MM-dd").parse(date18Str);
        Date date19 = new SimpleDateFormat("yyyy-MM-dd").parse(date19Str);
        LocalDate localDate18 = date18.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusYears(2);
        LocalDate localDate19 = date19.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusYears(2);

        System.out.println("localDate18 = " + localDate18);
        System.out.println("localDate19 = " + localDate19);
    }

    /**
     * LocalDate比较，是以日期进行比较，不精确到时分秒
     * @author Kang Yong
     * @date 2024/6/24
     *
     *
     */
    @Test
    public void testIsBefore() {
        String deliverDate = "2024-06-20";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate deliverD = LocalDate.parse(deliverDate, dtf);
        LocalDate deliverD = LocalDate.parse(deliverDate);

        System.out.println("deliverD.isBefore(LocalDate.now()) = " + deliverD.isBefore(LocalDate.now()));
        System.out.println("deliverD.isBefore(LocalDate.now()) = " + deliverD.isBefore(LocalDate.now()));
        System.out.println("deliverD.isBefore(LocalDate.now()) = " + deliverD.isBefore(LocalDate.now()));
    }

}
