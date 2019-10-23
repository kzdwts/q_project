package code01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 计算天数
 * @author: kangyong
 * @date: 2019/10/23 11:39
 * @version: v1.0
 */
public class Demo14CalcDay {

    public static void main(String[] args) {
        /*
        输入某年某月某日，判断这一天是这一年的第几天
         */

        // 读取
        String date = readInputDate();
        String[] dates = date.split("-");

        // 分离年月日
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int num = 0;
        boolean isLeap = false;

        // 计算
        num = calcDayOfNumInYear(year, month, day, num, isLeap);

        // 输出
        System.out.println(date + "是这一年的第" + num + "天");

    }

    /**
     * 计算是一年的第几天
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param num    第num天
     * @param isLeap 是否润年
     * @return
     */
    private static int calcDayOfNumInYear(int year, int month, int day, int num, boolean isLeap) {
        // 是否润年（4年一润，百年不润，400年一润）
        if ((year % 4 == 0) && !(year % 100 == 0) && (year % 400 == 0)) {
            isLeap = true;
        }

        // 计算
        for (int i = 1; i < month; i++) {
            num += getMonthFullDay(i, isLeap);
        }
        num += day;
        return num;
    }

    /**
     * 读取日期
     *
     * @return
     */
    private static String readInputDate() {
        System.out.println("请输入年月日，格式：yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        sc.close();
        return date;
    }

    /**
     * 获取这个月的天数
     *
     * @param month
     * @return
     */
    private static int getMonthFullDay(int month, boolean isLeap) {
        int num = 0;
        switch (month) {
            case 2:
                num = isLeap ? 29 : 28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                num = 31;
                break;
            default:
                num = 30;
        }
        return num;
    }

}
