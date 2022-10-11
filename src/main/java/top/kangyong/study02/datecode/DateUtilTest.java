package top.kangyong.study02.datecode;

import org.junit.Test;

import java.util.List;

/**
 * date util test
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
public class DateUtilTest {

    @Test
    public void testGetDayListOfMonth() {
        List<String> list = DateUtil.getDayListOfMonth();
        list.forEach(System.out::println);
    }

}
