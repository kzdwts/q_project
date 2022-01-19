package top.kangyong.study02.datecode;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * java8全新的日期和时间API LocalDateTime
 *
 * @author Kang Yong
 * @date 2022/1/19
 * @since 1.0.0
 */
public class LocalDateTimeTest {

    @Test
    public void demo01() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }

    @Test
    public void demo02() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(new Date().getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        Date date = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(localDateTime);
        System.out.println(startOfDay);
        System.out.println(date);
    }
}
