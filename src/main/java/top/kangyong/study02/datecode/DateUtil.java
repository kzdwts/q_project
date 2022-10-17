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
            String monthStr = month + "";
            if (month < 10) {
                monthStr = "0" + month;
            }
            String dayStr = i + "";
            if (i < 10) {
                dayStr = "0" + i;
            }
            String dateStr = year + "-" + monthStr + "-" + dayStr;
            resultList.add(dateStr);
        }
        return resultList;
    }

    /**
     * 获取最近num个月的月份
     *
     * @param num {@link int} 前num个月
     * @return {@link List< String>}
     * @author Kang Yong
     * @date 2022/10/17
     */
    public static List<String> getLastMonthDate(int num) {
        List<String> monthList = new ArrayList<>(num);
        // 获取最近几个月的月份
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        for (int i = 0; i < num; i++) {
            calendar.add(Calendar.MONTH, -1);
            String month = calendar.get(Calendar.YEAR) + "-" + fillZero(calendar.get(Calendar.MONTH) + 1);
            monthList.add(month);
        }
        Collections.reverse(monthList);
        return monthList;
    }

    /**
     * 格式化 月/日
     *
     * @param i {@link Integer}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/10/17
     */
    public static String fillZero(Integer i) {
        String str = "";
        if (i < 10) {
            str = "0" + i;
        } else {
            str = String.valueOf(i);
        }
        return str;
    }

}
