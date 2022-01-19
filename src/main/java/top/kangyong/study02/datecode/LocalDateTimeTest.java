package top.kangyong.study02.datecode;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
