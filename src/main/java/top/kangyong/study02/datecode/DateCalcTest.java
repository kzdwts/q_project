package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 时间计算
 *
 * @author Kang Yong
 * @date 2022/1/17
 * @since 1.0.0
 */
public class DateCalcTest {

    /**
     * 时间相加
     *
     * @author Kang Yong
     * @date 2022/1/17
     */
    @Test
    public void addDateDayTest() {
        // 自然天
        Date date = DateUtils.addDays(new Date(), 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        System.out.println(sdf.format(date));

        // 24小时制度
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(date));
    }

    /**
     * 时间加5min
     *
     * @author Kang Yong
     * @date 2022/3/18
     */
    @Test
    public void addTimeMin() {
        Date afterDate = new Date(new Date().getTime() + 5 * 60 * 1000);
        System.out.println(afterDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(afterDate));
    }

    /**
     * 糊涂包的时间 操作
     *
     * @author Kang Yong
     * @date 2022/4/15
     */
    @Test
    public void offsetTest() {
        Date date = new Date();
        DateTime dateTime = DateTime.of(date.getTime()).offset(DateField.MONTH, 1);
        System.out.println(dateTime);
    }

    /**
     * 推一个月
     *
     * @author Kang Yong
     * @date 2022/4/15
     */
    @Test
    public void offsetTest02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse("2022-01-01 12:00:00");
        Date end = sdf.parse("2022-05-05 12:00:00");

        Date startTime = start;
        Date endTime = start;

        do {
            // 推一个月
            endTime = DateTime.of(startTime.getTime()).offset(DateField.MONTH, 1);
            System.out.println("startTime = " + startTime);
            System.out.println("endTime   = " + endTime);

            startTime = endTime;
        } while (endTime.before(end));
    }

    /**
     * 字符串转时间
     *
     * @author Kang Yong
     * @date 2022/5/9
     */
    @Test
    public void getDateByVal() throws ParseException {
        String dateStr = "2999-01-01 00:00:00";
//        Date date = DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
//        System.out.println(date);

        DateTime dateTime = DateUtil.parse(dateStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Date date = dateTime.toJdkDate();
        System.out.println(date);
    }

    /**
     * 可以用于缓存失效，加了随机时间，避免缓存雪崩事件
     *
     * @author Kang Yong
     * @date 2022/6/23
     */
    @Test
    public void test01() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        int delay = ThreadLocalRandom.current().nextInt(2, 10);
        LocalDateTime localDateTime = LocalDate.now().plusDays(1).atTime(0, 0, delay);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // 取两个时间间隔的秒数
        Duration between = Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atTime(0, 0, delay));
        System.out.println(between.getSeconds());
    }

    @Test
    public void test02() {
        Date date = new Date();
        System.out.println("date = " + date);

        Date date2 = Date.from(date.toInstant().plusSeconds(10));
        System.out.println("date2 = " + date2);
    }

    @Test
    public void test03() {
        LocalDateTime localDateTime = LocalDate.now().plusDays(-1).atStartOfDay();
        System.out.println(localDateTime);

        LocalDateTime now = LocalDate.now().atStartOfDay();
        System.out.println(now);
    }

    @Test
    public void test04() {
        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(date));
        Instant instant = date.toInstant().plusSeconds(10 * 60);
        Date from = Date.from(instant);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(from));
    }

    public static List<String> findEveryDay(Date beginTime, Date endTime) {
        List<String> dateList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        dateList.add(sdf.format(beginTime));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginTime);

        while (endTime.after(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(sdf.format(calendar.getTime()));
        }
        return dateList;
    }

    @Test
    public void testFindDateList() {
        DateTime bDate = DateUtil.beginOfMonth(new Date());
        DateTime eDate = DateUtil.endOfMonth(new Date());

        System.out.println("bDate = " + bDate);
        System.out.println("eDate = " + eDate);
        List<String> everyDay = findEveryDay(bDate, eDate);
        System.out.println("everyDay = " + everyDay);
    }

    @Test
    public void testDateDiffDay() throws ParseException {
        String dStr1 = "2022-12-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(dStr1);
        Date now = new Date();
        long between = DateUtil.between(now, d1, DateUnit.DAY);
        System.out.println(between);
    }

    @Test
    public void testBetweenDay() throws ParseException {
        String dStr1 = "2022-03-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(dStr1);
        long day = DateUtil.betweenDay(new Date(), d1, true);
        System.out.println(day);
    }

    /**
     * 计算两个时间相差多少天
     *
     * @author Kang Yong
     * @date 2023/1/9
     */
    @Test
    public void diffDay() {
        LocalDate startDate = LocalDate.of(2022, 03, 9);
        LocalDate endDate = LocalDate.now();

        long day = endDate.toEpochDay() - startDate.toEpochDay();
        System.out.println("day = " + day);
    }

    /**
     * 比较时间
     *
     * @author Kang Yong
     * @date 2023/2/28
     */
    @Test
    public void beforeOrAfterDate_compare() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();

        Date date2 = new Date(2024, 10, 9);

        System.out.println("date1 = " + sdf.format(date1));
        System.out.println("date2 = " + sdf.format(date2));

        System.out.println("date1.before(date2) = " + date1.before(date2));

    }

    /**
     * 测试before
     * @throws ParseException
     */
    @Test
    public void testDateBefore() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Date date2 = new Date();
        String date3Str = "2023-03-20 11:00:00";
        Date date3 = sdf.parse(date3Str);

        System.out.println("date1.before(date2) = " + date1.before(date2));
        System.out.println("date1.before(date3) = " + date1.before(date3));
    }

    /**
     * 比较时间
     *
     * @author Kang Yong
     * @date 2023/2/28
     */
    @Test
    public void beforeDate_compare() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Date date2 = new Date();
        String date3Str = "2023-03-20 11:00:00";
        Date date3 = sdf.parse(date3Str);
        String date4Str = "2023-11-20 11:00:00";
        Date date4 = sdf.parse(date4Str);

        System.out.println("date1 = " + sdf.format(date1));
        System.out.println("date2 = " + sdf.format(date2));
        System.out.println("date3 = " + date3Str);

        System.out.println("date1.before(date2) = " + date1.before(date2));
        System.out.println("date1.compareTo(date2) = " + date1.compareTo(date2));
        System.out.println("date1.compareTo(date3) = " + date1.compareTo(date3));
        System.out.println("date1.compareTo(date4) = " + date1.compareTo(date4));

    }

    @Test
    public void testDateSub() {
        Date date1 = new Date();
        long time1 = date1.getTime();
        System.out.println("time1 = " + time1);

        Date date2 = new Date(time1 + 1);
        long time2 = date2.getTime();
        System.out.println("time2 = " + time2);

        boolean flag = date1.before(date2);
        System.out.println("flag = " + flag);

    }

    @Test
    public void dayStartEnd() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = "2023-03-21";

        Date date1 = sdf.parse(d1);
        System.out.println("date1 = " + date1);

        DateTime dayStart = DateUtil.endOfDay(date1);
        DateTime dayEnd = DateUtil.beginOfDay(date1);

        System.out.println("dayStart = " + dayStart);
        System.out.println("dayEnd = " + dayEnd);
    }

    /**
     * 测试时间转为毫秒 | 秒
     *
     * @author Kang Yong
     * @date 2023/5/20
     */
    @Test
    public void date2Long() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("time = " + time);

        long second = time / 1000;
        System.out.println("second = " + second);
    }

    @Test
    public void testDateUtilFormat() throws ParseException {
        String dateStr = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println("format = " + dateStr);

        Date date = new SimpleDateFormat("HH:mm").parse(dateStr);
        System.out.println("date = " + date);

        String date2 = DateUtil.format(date, "HH:mm");
        System.out.println("date2 = " + date2);
    }


    @Test
    public void testDateOfMonth() {
        int day = DateUtil.dayOfMonth(new Date());
        System.out.println("day = " + day);
    }


}
