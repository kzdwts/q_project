package top.kangyong.study02.datecode;

import org.junit.Test;

import java.time.LocalDate;

/**
 * java8全新的日期和时间API LocalDate
 *
 * @author Kang Yong
 * @date 2022/1/18
 * @since 1.0.0
 */
public class LocalDateTest {

    /**
     * 创建LocalDate
     */
    @Test
    public void demo01() {
        // 获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // 构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        System.out.println(localDate1);
    }
}
