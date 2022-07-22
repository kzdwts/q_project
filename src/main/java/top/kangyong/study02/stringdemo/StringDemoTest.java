package top.kangyong.study02.stringdemo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String字符串操作
 *
 * @author Kang Yong
 * @date 2022/1/13
 * @since 1.0.0
 */
public class StringDemoTest {

    /**
     * 字符串替换 replace
     *
     * @author Kang Yong
     * @date 2022/1/13
     */
    @Test
    public void testReplace() {
        String world = "我喜欢的人是那个谁来着";
        String str = world.replace("喜欢", "讨厌");
        System.out.println(str);
    }

    @Test
    public void testReplace2() {
        String str1 = "imk_sms_send:key:";
        String key = str1 + "20220328300" + ":175";
        System.out.println(key);

        String str2 = "imk_sms_send:vkey:" + key.replace(str1, "");
        System.out.println(str2);
    }

    @Test
    public void parseInt() {
        String numStr = "05";
        int num = Integer.parseInt(numStr);
        System.out.println(numStr);
        System.out.println(num);
    }

    @Test
    public void testSubstring() {
        String str = "你好，我是王丽丽；";
        str = str.substring(0, str.length() - 1);
        System.out.println(str);
    }

    @Test
    public void testSplit() {
//        String str = "sale_house.cus_customer_progress";
//        String[] split = str.split("\\.");
//        for (int c = 0; c < split.length; c++) {
//            System.out.println(split[c]);
//        }

        String str = ".id";
        String[] split = str.split("\\.");
        for (int c = 0; c < split.length; c++) {
            System.out.println(split[c]);
        }
    }

    @Test
    public void testRegex() {
        /**
         * 变量抽取pattern
         */
        Pattern VARIABLE_PATTERN = Pattern.compile ("(#\\w+)|(\\.?\\w+)"); // (#\w+\[?)|(\.?\w+)+|]
//        String str = "#context[sale_house.cus_customer_detail.name]";
        String str = "#body.id";

        Matcher m = VARIABLE_PATTERN.matcher (str);

        while (m.find()) {
            String group = m.group();
            System.out.println(group);
        }
    }


}
