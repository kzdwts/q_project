package util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public static final DateTimeFormatter dayfmtSeparator = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter monthformatter = DateTimeFormatter.ofPattern("yyyyMM");

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
        Date date = sdf.parse("2020-02-01");
        LocalDate localDate = dateToLocalDate(date);
        System.out.println(date);
        System.out.println(localDate);

        // 昨日所在的月份
        String yesterdayInMonth = localDate.plusDays(-1).format(monthformatter);
        System.out.println(yesterdayInMonth);
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

        // 前天，不带分隔符
        String theDayBeforeYesterDaySep = now.plusDays(-2).format(dayformatter);
        // 前天，带分隔符
        String theDayBeforeYesterDayStr = now.plusDays(-2).format(dayfmtSeparator);

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

        System.out.println(crtMonth);
        System.out.println(lastMonthLastDay);

    }

}
