package test01;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;
import sun.text.resources.FormatData;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: map
 * User: kangyong
 * Date: 2019/1/21 10:33
 */
public class Test02 {

    public static void main(String[] args) {
        List<Map<String, Object>> lm = new ArrayList<>();

        // 第一个
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "xiaomei");
        map1.put("sex", "女");
        lm.add(map1);

        // 第二个
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "meimei");
        map2.put("sex", "femal");
        lm.add(map2);

        System.out.println(lm.get(0).toString());

        System.out.println(lm.get(1).toString());
    }

    /**
     * 测试
     */
    @Test
    public void test01() {
        String dateStr = "2018-02-12 13:30:00";
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();

        try {
            date = fdf.parse(dateStr.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
    }


    @Test
    public void test02() {
        Map<String, Object> map = new HashMap<>();
        // 存
        map.put("key", "value");
        System.out.println(map.isEmpty());
        if (map != null && !map.isEmpty()) {
            System.out.println("不为空");
        }

        System.out.println("over");
    }

    /**
     * 正则解析
     */
    @Test
    public void test03() {
        String tel = "182s32s5|8u@34a^%27636";
        tel = tel.replaceAll("[^0-9]|3", "");
        System.out.println(tel);
    }

    /**
     * 测试从map中获取值
     */
    @Test
    public void test04() {
        Map<String, Object> params = new HashMap<>();
        String outOdrId = (String) params.get("outOdrId");
        System.out.println(outOdrId);
    }

    /**
     * 作用域
     */
    @Test
    public void test05() {
        System.out.println("开始");
        for (int i = 0; i < 10; i++) {
            System.out.println("NO." + i);
        }

        if (true) {
            int num = 99;
            System.out.println(num);
        }
//        System.out.println(num);
    }
}
