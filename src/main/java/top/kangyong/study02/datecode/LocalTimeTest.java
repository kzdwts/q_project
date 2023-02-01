package top.kangyong.study02.datecode;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

/**
 * java8全新的日期和时间API LocalTime
 *
 * @author Kang Yong
 * @date 2022/1/18
 * @since 1.0.0
 */
public class LocalTimeTest {

    @Test
    public void demo01() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(16, 55, 10);
        System.out.println(localTime1);
    }

    /**
     * 获取时分秒
     */
    @Test
    public void demo02() {
        LocalTime localTime = LocalTime.now();
        //获取小时
        int hour = localTime.getHour();
        int hour2 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute2 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getSecond();
        int second2 = localTime.get(ChronoField.SECOND_OF_MINUTE);

        System.out.println(hour);
        System.out.println(hour2);
        System.out.println(minute);
        System.out.println(minute2);
        System.out.println(second);
        System.out.println(second2);
    }

    /**
     * 测试时间 +1s
     *
     * @author Kang Yong
     * @date 2023/2/1
     */
    @Test
    public void dateAddSecond() {
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(1);
        System.out.println(localDateTime);
    }
}
