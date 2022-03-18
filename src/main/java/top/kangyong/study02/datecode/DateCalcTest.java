package top.kangyong.study02.datecode;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
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

}
