package top.kangyong.study02.datecode;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import org.junit.Test;

import java.util.Date;

/**
 * hutool DateUtil 测试
 *
 * @author Kang Yong
 * @date 2024/7/16
 * @since 1.0.0
 */
public class HtDateUtilTest {

    @Test
    public void now() {
        String now = DateUtil.now();
        System.out.println("now = " + now);

        String today = DateUtil.today();
        System.out.println("today = " + today);
    }

    @Test
    public void parseTest() {
        DateTime dateTime = DateUtil.date();
        System.out.println("dateTime = " + dateTime);

        Month month = DateUtil.monthEnum(new Date());
        System.out.println("month = " + month);
    }

    /**
     * DateUtil 获取星座
     *
     * @author Kang Yong
     * @date 2024/7/16
     */
    @Test
    public void showXingZuo() {
        int may = Month.MAY.getValue();
        String zodiac1 = DateUtil.getZodiac(may, 17);
        System.out.println("zodiac1 = " + zodiac1);

        String zodiac2 = DateUtil.getZodiac(Month.OCTOBER.getValue(), 24);
        System.out.println("zodiac2 = " + zodiac2);
    }

    /**
     * DateUtil 获取属相
     *
     * @author Kang Yong
     * @date 2024/7/16
     */
    @Test
    public void showChineseZodiac() {
        String chineseZodiac1 = DateUtil.getChineseZodiac(1995);
        System.out.println("chineseZodiac1 = " + chineseZodiac1);

        String chineseZodiac2 = DateUtil.getChineseZodiac(1998);
        System.out.println("chineseZodiac2 = " + chineseZodiac2);
    }

}
