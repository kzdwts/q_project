package code01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 统计
 * User: kangyong
 * Date: 2018/12/27 17:29
 */
public class Demo07CountNum {

    public static void main(String[] args) {
        /*
        输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符");
        String str = sc.nextLine();
        sc.close();
        // countNum1(str);
        countNum2(str);
    }

    /**
     * 统计每个字符个数
     *
     * @param str
     */
    private static void countNum1(String str) {
        // 转为字符数组
        char[] chars = str.toCharArray();
        // 存储字符和数量
        Map<Character, Integer> map = new HashMap<>();
        // 遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                // 获取数量
                Integer num = map.get(chars[i]);
                // 增加数量
                map.put(chars[i], ++num);
            } else {
                map.put(chars[i], 1);
            }
        }

        // 输出
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> m : entries) {
            System.out.println(m.getKey() + " 的数量是 " + m.getValue());
        }
    }

    /**
     * 分别统计出其中英文字母、空格、数字和其它字符的个数
     *
     * @param str
     */
    private static void countNum2(String str) {
        // 转换成字符数组
        char[] chars = str.toCharArray();
        // 存储结果
        Map<String, Integer> map = new HashMap<>();

        // 遍历处理
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                // 数字
                if (map.get("digitNum") != null) {
                    map.put("digitNum", map.get("digitNum") + 1);
                } else {
                    map.put("digitNum", 1);
                }
            } else if (Character.isWhitespace(chars[i])) {
                // 空格
                if (map.get("whitespaceNum") != null) {
                    map.put("whitespaceNum", map.get("whitespaceNum") + 1);
                } else {
                    map.put("whitespaceNum", 1);
                }
            } else if (Character.isLetter(chars[i])) {
                // 字母
                if (map.get("letterNum") != null) {
                    map.put("letterNum", map.get("letterNum") + 1);
                } else {
                    map.put("letterNum", 1);
                }
            } else {
                // 其他字符
                if (map.get("otherNum") != null) {
                    map.put("otherNum", map.get("otherNum") + 1);
                } else {
                    map.put("otherNum", 1);
                }
            }
        }

        // 输出
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + "数量" + e.getValue());
        }
    }

}
