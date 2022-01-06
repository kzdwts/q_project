package top.kangyong.study01.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 时间处理工具类
 * @author: kangyong
 * @date: 2020/2/11 14:55
 * @version: v1.0
 */
public class DateUtils {

    private static final DateTimeFormatter dayformatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter dayfmtSeparator = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter monthformatter = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter yearformatter = DateTimeFormatter.ofPattern("yyyy");

    private String dbName = "food";

    public static long getDateTimePoor(Date endDate, Date nowDate) {
        return Math.abs(endDate.getTime() - nowDate.getTime());
    }


    /**
     * Date转换为LocalDate
     *
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * 测试昨日所在月份
     *
     * @throws ParseException
     */
    @Test
    public void demoTest1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-03-01");
        LocalDate localDate = dateToLocalDate(date);

        // 昨日所在的月份
        String yesterdayInMonth = localDate.plusDays(-1).format(monthformatter);
        System.out.println(yesterdayInMonth);

        // 昨天的上个月
        String ystDayLastMonth = localDate.plusDays(-1).plusMonths(-1).format(monthformatter);
        // 昨天的上个月最后一天
        String ystDayLastMonthLastDay = localDate.plusDays(-1).plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth()).format(dayformatter);

        System.out.println(ystDayLastMonth);
        System.out.println(ystDayLastMonthLastDay);
    }

    /**
     * 测试LocalDate的方法
     *
     * @throws ParseException
     */
    @Test
    public void demoTest2() throws ParseException {
        // 时间参数
        LocalDate now = LocalDate.now();

        String da = now.plusDays(30).format(dayfmtSeparator);
        System.out.println(da);

        // 前天，不带分隔符
        String theDayBeforeYesterDayStr = now.plusDays(-2).format(dayformatter);
        // 前天，带分隔符
        String theDayBeforeYesterDaySep = now.plusDays(-2).format(dayfmtSeparator);

        // 昨日，不带分隔符
        String dayStr = now.plusDays(-1).format(dayformatter);
        // 昨日，带分隔符
        String ystDaySep = now.plusDays(-1).format(dayfmtSeparator);

        // 今日，不带分隔符
        String crtDayStr = now.format(dayformatter);
        // 今日，带分隔符
        String crtDaySep = now.format(dayfmtSeparator);

        // 本月
        String crtMonth = now.plusDays(-1).format(monthformatter);
        // 上个月
        String lastMonth = now.plusMonths(-1).format(monthformatter);

        // 上月最后一天
        String lastMonthLastDay = now.plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth()).format(dayformatter);

        // 昨天的上个月
        String ystDayLastMonth = now.plusDays(-1).plusMonths(-1).format(monthformatter);

        int crtYearStr = now.getYear();

        String lastYearStr = now.minusYears(1).format(yearformatter);

        // 昨天的年月
        String ystYearMonth = now.plusDays(-1).format(monthformatter);
        // 昨天的月份
        String ystMonthVal = now.plusDays(-1).getMonthValue() + "";
        // 昨天是这个月的第几天
        String ystDayOfMonthVal = now.plusDays(-1).getDayOfMonth() + "";

        String ystLastYearMonth = now.plusDays(-1).minusMonths(1).format(monthformatter);

        // 昨天的上一年最后一个月
        String ystLastYearLastMonth = now.plusDays(-1).minusYears(1).with(TemporalAdjusters.lastDayOfYear()).format(monthformatter);

        System.out.println(ystYearMonth);
        System.out.println(ystMonthVal);
        System.out.println(ystDayOfMonthVal);
        System.out.println(ystLastYearLastMonth);

        System.out.println(dbName);


    }

    @Test
    public void getYestInMonth() {
        LocalDate now = LocalDate.now();
        String yestInMonth = now.plusDays(-1).format(monthformatter);
        System.out.println(yestInMonth);

    }

}
