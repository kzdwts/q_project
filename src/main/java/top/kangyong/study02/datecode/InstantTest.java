package top.kangyong.study02.datecode;

import org.junit.Test;

import java.time.Instant;

/**
 * java8全新的日期和时间API Instant
 *
 * @author Kang Yong
 * @date 2022/1/19
 * @since 1.0.0
 */
public class InstantTest {

    @Test
    public void demo01() {
        Instant instant = Instant.now();
        System.out.println(instant);

        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);
    }
}
