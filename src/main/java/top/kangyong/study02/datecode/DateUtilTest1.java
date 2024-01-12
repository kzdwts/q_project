package top.kangyong.study02.datecode;

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

}
