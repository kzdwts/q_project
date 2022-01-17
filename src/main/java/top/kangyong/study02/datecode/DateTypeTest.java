package top.kangyong.study02.datecode;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间相关
 *
 * @author Kang Yong
 * @date 2022/1/10
 * @since 1.0.0
 */
public class DateTypeTest {

    /**
     * CST date
     *
     * @author Kang Yong
     * @date 2022/1/10
     */
    @Test
    public void showCSTDate() {
        // CST 时间
        System.out.println(new Date());
    }

    /**
     * GMT date
     *
     * @author Kang Yong
     * @date 2022/1/10
     */
    @Test
    public void showGMTDate() {
        // GMT 时间
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(cd.getTime()));

        // GMT 时间
        System.out.println(new Date().toGMTString());

        // GMT 时间
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String gmt = df.format(new Date()) + "Z";
        System.out.println(gmt);

        // GMT 时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf2.format(new Date()));
    }

    /**
     * 显示GMTdate
     */
    @Test
    public void showGMTDate2() {
        String gmtDate = LocalDateTime.now().atZone(ZoneId.of("GMT")).format(DateTimeFormatter.RFC_1123_DATE_TIME);
        System.out.println(gmtDate);
//        Mon, 17 Jan 2022 10:22:26 GMT
//        Mon, 17 Jan 2022 02:22:48 GMT
    }

}
