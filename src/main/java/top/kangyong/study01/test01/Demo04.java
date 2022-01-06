package top.kangyong.study01.test01;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/12/2 15:20
 * @version: v1.0
 */
public class Demo04 {

    private static final DateTimeFormatter SERVER_FULL_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");

    private static final DateTimeFormatter SERVER_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Test
    public void test01() {
        String str = "start";
        StringBuilder sb = new StringBuilder("start");
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            str = str + " Hello";
        }
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            sb.append(" Hello");
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(sb.toString());
        System.out.println(str);
    }

    @Test
    public void test02() {
        LocalDate date = LocalDate.now().minusDays(1);
        LocalDate yesterday = date.minusDays(1);
        String startTime = yesterday.format(SERVER_FORMATTER) + "T160000";
        String endTime = date.format(SERVER_FORMATTER) + "T155959";
        int pageSize = 2000;
        int pageIndex = 1;
        int totalPage = 1;

        System.out.println(startTime);
        System.out.println(endTime);

    }

    @Test
    public void test03() {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:dd");
//        String date = "2020-04-24 12:00:00.0";
//        LocalDateTime date1 = LocalDateTime.parse(date, df);
//        System.out.println(date1);
        String text = "2020-04-24 12:00:00.0";
        text = text.substring(0, text.lastIndexOf("."));
        System.out.println(text);
        LocalDateTime dateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test04() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李子木");
        map.put("age", 21);

        map.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    @Test
    public void test05() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("name=wll");
        arrayDeque.add("sex=nv");
        arrayDeque.add("weight=100kg");

        arrayDeque.forEach(System.out::println);
    }

}
