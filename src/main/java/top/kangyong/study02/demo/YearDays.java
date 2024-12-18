package top.kangyong.study02.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * 打印年每一天
 *
 * @author Kang Yong
 * @date 2024/12/18
 * @since 1.0.0
 */
public class YearDays {

    public static void main(String[] args) {
        int year = 2024;
        List<Day> dayList = getAllDaysOfYear(year);

        for (Day day : dayList) {
            System.out.println("day = " + day);
        }
    }

    public static List<Day> getAllDaysOfYear(int year) {
        List<Day> days = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            YearMonth yearMonthObject = YearMonth.of(year, month);
            int daysInMonth = yearMonthObject.lengthOfMonth();

            for (int day = 1; day <= daysInMonth; day++) {
                LocalDate date = LocalDate.of(year, month, day);
                DayOfWeek dayOfWeek = date.getDayOfWeek();

                // 状态：1-正常工作日，3-周末
                int status = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) ? 3 : 1;

                days.add(new Day(year, month, day, status));
            }
        }

        return days;
    }
}
