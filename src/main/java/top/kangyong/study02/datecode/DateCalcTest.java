package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

}
