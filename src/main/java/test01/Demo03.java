package test01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/11/11 9:58
 * @version: v1.0
 */
public class Demo03 {

//    public static void main(String[] args) {
//        Map<String, Object> userMap = new HashMap<>();
//        userMap.put("custName", "问问");
//        userMap.put("age", 18);
//        userMap.put("certNbr", "340121200006073119");
//
//        System.out.println(userMap);
//        userMap.replace("custName", userMap.get("custName").equals("") ? "" : userMap.get("custName").toString().substring(0, 1) + "**");
//        System.out.println(userMap);
//        userMap.put("custName", "文文");
//        System.out.println(userMap);
//
//        userMap.replace("certNbr", userMap.get("certNbr").toString().replaceAll("(\\d{4})\\d{10}(\\d{4}|(\\d{3}[Xx]))", "$1****$2"));
//        System.out.println(userMap);
//    }

    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 99; i++) {
            a = a++;
        }
        System.out.println(a);

        int b = 0;
        for (int i = 0; i < 99; i++) {
            b = ++b;
        }
        System.out.println(b);
    }

}
