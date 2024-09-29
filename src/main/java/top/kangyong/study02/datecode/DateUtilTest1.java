package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/1/12
 * @since 1.0.0
 */
public class DateUtilTest1 {

    @Test
    public void testSameDay() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse("2024-01-12 00:05:00");
        Date end = sdf.parse("2024-01-12 23:00:00");
        boolean sameDay1 = DateUtil.isSameDay(start, new Date());
        boolean sameDay2 = DateUtil.isSameDay(end, new Date());
        System.out.println("sameDay1 = " + sameDay1);
        System.out.println("sameDay2 = " + sameDay2);
    }

    @Test
    public void testYesterday() {
        DateTime yesterday = DateUtil.yesterday();
        System.out.println("yesterday = " + yesterday);

        String str = yesterday.toString("yyyy-MM-dd");
        System.out.println("str = " + str);

        String beginOfMonth = DateUtil.beginOfMonth(DateUtil.date()).toString("yyyy-MM-dd");
        System.out.println("beginOfMonth = " + beginOfMonth);
        String endOfMonth = DateUtil.endOfMonth(DateUtil.date()).toString("yyyy-MM-dd");
        System.out.println("endOfMonth = " + endOfMonth);

        String startTime = DateUtil.beginOfQuarter(DateUtil.date()).toString("yyyy-MM-dd");
        String endTime = DateUtil.endOfQuarter(DateUtil.date()).toString("yyyy-MM-dd");
        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);

        startTime = DateUtil.beginOfYear(DateUtil.date()).toString("yyyy-MM-dd");
        endTime = DateUtil.endOfYear(DateUtil.date()).toString("yyyy-MM-dd");
        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);
    }

    @Test
    public void testEndOfDay() {
        String dateStr = "2024-01-12";
        DateTime dateTime = DateUtil.endOfDay(DateUtil.parseDate(dateStr));
        String endOfDay = dateTime.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("endOfDay = " + endOfDay);
    }

}
