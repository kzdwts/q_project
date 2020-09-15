package demo;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/8/1 10:32
 * @version: v1.0
 */
public class Demo06 {

    @Test
    public void test01() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

    }

    @Test
    public void test02() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void test03() {
        Integer num = 1000000;
        if (num == 1000000) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Integer b = 1000000;
        System.out.println(num == b);
    }

}
