package top.kangyong.study01.test01;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/7/5 11:11
 * @version: v1.0
 */
public class TestString {

    /**
     * 循环查找
     *
     * @param source
     * @param target
     * @param num
     * @param result
     */
    public static List<String> findStringArray(String source, String target, int num) {
        List<String> result = new ArrayList<String>(0);
        int index = 0;
        int preIndex = 0;
        int sum = 0;
        while ((index = source.indexOf(target, index)) != -1) {
            index++;
            sum++;
            if (sum > 0 && sum % num == 0) {
                String s = source.substring(preIndex, index);
                s = s.substring(0, s.lastIndexOf(target));
                preIndex = index;
                result.add(s);
            }
        }
        if (preIndex < source.length()) {
            if (source.endsWith(target)) {
                String s = source.substring(preIndex);
                int lastCommaIndex = s.lastIndexOf(target);
                if (lastCommaIndex != -1) {
                    s = s.substring(0, lastCommaIndex);
                }
                result.add(s);
            } else {
                result.add(source);
            }
        }
        return result;
    }

    /**
     * 递归查找
     *
     * @param source
     * @param target
     * @param num
     * @param result
     * @return
     */
    public static boolean findStringArrayWhile(String source, String target, int num, List<String> result) {
        int index = 0;
        int sum = 0;
        if (source.indexOf(target) == -1) {
            result.add(source);
            return true;
        }
        while ((index = source.indexOf(target, index)) != -1) {
            sum++;
            index++;
            if (sum > 0 && sum % num == 0) {
                String s = source.substring(0, index);
                s = s.substring(0, s.lastIndexOf(target));
                result.add(s);
                if (source.length() < index) {
                    result.add(source);
                    return true;
                }
                source = source.substring(index);
                boolean t = findStringArrayWhile(source, target, num, result);
                if (t) {
                    return true;
                }
            }
        }
        if (source.length() % num < num) {
            result.add(source);
            return true;
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String source = "1,2,3,4,5,6,7,8,9,0";
        List<String> result = new ArrayList<String>(0);
        result = findStringArray("1,2,3,4", ",", 4);


//        findStringArrayWhile(source, ",", 10, result);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private List<String> getClassCodeSplit(String classCodes, Integer len) {
        // 班级编码处理
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(classCodes)) {
            List<String> codeList = Arrays.asList(classCodes.split(","));
            for (int i = 0; i < codeList.size(); i+=len) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < codeList.size(); j++) {
                    if (j < i+len) {
                        sb.append(codeList.get(j) + ",");
                    }
                }
                list.add(sb.deleteCharAt(sb.length()-1).toString());
            }
        }
        return list;
    }

    @Test
    public void test02() {
        String str = "1,2,3";
        List<String> classCodeSplit = this.getClassCodeSplit(str, 3);
        classCodeSplit.forEach(System.out::println);
    }
}
