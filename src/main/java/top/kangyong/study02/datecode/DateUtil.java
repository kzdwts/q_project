package top.kangyong.study02.datecode;

import java.time.LocalDate;
import java.util.*;

/**
 * 日期工具类
 *
 * @author Kang Yong
 * @date 2022/10/11
 * @since 1.0.0
 */
public class DateUtil {

    /**
     * 获取当月所有天
     *
     * @return {@link List< String>}
     * @author Kang Yong
     * @date 2022/10/11
     */
    public static List<String> getDayListOfMonth() {
        List<String> resultList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String dateStr = String.valueOf(year) + "-" + month + "-" + i;
            resultList.add(dateStr);
        }
        return resultList;
    }

    /**
     * 获取当前时间所在月的每一天
     *
     * @param date {@link Date}
     * @return {@link List< String>}
     * @author Kang Yong
     * @date 2022/10/11
     */
    public static List<String> getDayListOfMonth(Date date) {
        List<String> resultList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String dateStr = String.valueOf(year) + "-" + month + "-" + i;
            resultList.add(dateStr);
        }
        return resultList;
    }

}
