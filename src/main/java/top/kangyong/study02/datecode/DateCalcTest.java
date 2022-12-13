package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        LocalDateTime localDateTime = LocalDate.now().plusDays(-1).atStartOfDay();
        System.out.println(localDateTime);

        LocalDateTime now = LocalDate.now().atStartOfDay();
        System.out.println(now);
    }

    @Test
    public void test03() {
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
        String dStr1 = "2022-12-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(dStr1);
        long day = DateUtil.betweenDay(new Date(), d1, true);
        System.out.println(day);
    }


}
