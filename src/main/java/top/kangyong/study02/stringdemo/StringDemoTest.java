package top.kangyong.study02.stringdemo;

import org.apache.commons.lang3.StringUtils;
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
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();

        String names = sb.toString();
        System.out.println(StringUtils.isBlank(names));
        System.out.println(names.length());
        System.out.println(names);

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
        Pattern VARIABLE_PATTERN = Pattern.compile("(#\\w+)|(\\.?\\w+)"); // (#\w+\[?)|(\.?\w+)+|]
//        String str = "#context[sale_house.cus_customer_detail.name]";
        String str = "#body.id";

        Matcher m = VARIABLE_PATTERN.matcher(str);

        while (m.find()) {
            String group = m.group();
            System.out.println(group);
        }
    }

    @Test
    public void testRegex2() {

        String pattern1 = ".*(EXPORT).*|.*(IMPORT).*";
        String msg1 = "2022-08-16 16:16:17.060|[,,,]|[Thread-41]|INFO |com.youmatech.zhsq.operateprogress.OperateProgressMain|EXPORT|server-mobile|1206503|USERINFO|获取当前登录者信息:[{\"bguTokenId\":null,\"bguUserId\":null,\"userUuid\":null,\"userName\":null,\"platformCode\":null,\"systemCode\":null,\"token\":null,\"systemInfo\":null,\"softWare\":null,\"loginName\":null,\"orgUserId\":2331,\"orgUserUuid\":null,\"busBusinessId\":11,\"busBusinessName\":\"合生\",\"orgBusinessId\":null,\"userAdminFlag\":0}]|BODY:{\"progressTypeCode\":3,\"progressParamData\":{\"consultantCondition\":\"\",\"customerCondition\":\"\",\"syncFlagList\":[],\"customerProgressCodeList\":[],\"purposeLevelIdList\":[],\"validStatusCodeList\":[],\"consultantName\":\"\",\"customerOriginCode\":null,\"busProjectId\":78,\"distributeStatusCode\":1203531,\"followStartTime\":\"\",\"followEndTime\":\"\",\"distributeStartTime\":\"\",\"distributeEndTime\":\"\",\"invalidStartTime\":\"\",\"invalidEndTime\":\"\",\"discardStartTime\":\"\",\"discardEndTime\":\"\",\"cusCondition\":\"\"},\"progressBusinessCode\":1206503,\"accessToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMzMxIiwiYnVzQnVzaW5lc3NJZCI6MTEsImV4cGlyZXNEYXRlIjoxNjYxNTI2NDAwOTI2LCJleHAiOjE2NjE1MjY0MDB9.qzun_XGkfJIcicBKg5g25A1Hwf7LC_fRf2HyRQ2l-wnP_nEiz0PJ_i7p6PI20IPO8cA90PTG-gOdLoTVOwZicA\"}|RESP:{\"code\":3001,\"msg\":\"操作成功\",\"data\":{\"count\":6,\"excelHttpPath\":\"https://dev-jiaofu.yuanzhiyijiantong.com/resources/tmp/2022-08-16/5ac7d201-fcb8-4af5-ba6c-09030b1d0b9e/跟进中客户导出.xlsx\"},\"error\":null,\"success\":true}";

        boolean m1 = Pattern.matches(pattern1, msg1);
        System.out.println(m1);

        String msg2 = "2022-08-16 16:16:17.060|[,,,]|[Thread-41]|INFO |com.youmatech.zhsq.operateprogress.OperateProgressMain|IMPORT|server-mobile|1206503|USERINFO|获取当前登录者信息:[{\"bguTokenId\":null,\"bguUserId\":null,\"userUuid\":null,\"userName\":null,\"platformCode\":null,\"systemCode\":null,\"token\":null,\"systemInfo\":null,\"softWare\":null,\"loginName\":null,\"orgUserId\":2331,\"orgUserUuid\":null,\"busBusinessId\":11,\"busBusinessName\":\"合生\",\"orgBusinessId\":null,\"userAdminFlag\":0}]|BODY:{\"progressTypeCode\":3,\"progressParamData\":{\"consultantCondition\":\"\",\"customerCondition\":\"\",\"syncFlagList\":[],\"customerProgressCodeList\":[],\"purposeLevelIdList\":[],\"validStatusCodeList\":[],\"consultantName\":\"\",\"customerOriginCode\":null,\"busProjectId\":78,\"distributeStatusCode\":1203531,\"followStartTime\":\"\",\"followEndTime\":\"\",\"distributeStartTime\":\"\",\"distributeEndTime\":\"\",\"invalidStartTime\":\"\",\"invalidEndTime\":\"\",\"discardStartTime\":\"\",\"discardEndTime\":\"\",\"cusCondition\":\"\"},\"progressBusinessCode\":1206503,\"accessToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMzMxIiwiYnVzQnVzaW5lc3NJZCI6MTEsImV4cGlyZXNEYXRlIjoxNjYxNTI2NDAwOTI2LCJleHAiOjE2NjE1MjY0MDB9.qzun_XGkfJIcicBKg5g25A1Hwf7LC_fRf2HyRQ2l-wnP_nEiz0PJ_i7p6PI20IPO8cA90PTG-gOdLoTVOwZicA\"}|RESP:{\"code\":3001,\"msg\":\"操作成功\",\"data\":{\"count\":6,\"excelHttpPath\":\"https://dev-jiaofu.yuanzhiyijiantong.com/resources/tmp/2022-08-16/5ac7d201-fcb8-4af5-ba6c-09030b1d0b9e/跟进中客户导出.xlsx\"},\"error\":null,\"success\":true}";

        boolean m2 = Pattern.matches(pattern1, msg2);
        System.out.println(m2);
    }

    @Test
    public void formatTest() {
        String str = "%s,%s,did you know?";
        String content = String.format(str, "wanglili", "love eat");
        System.out.println("str: " + str);
        System.out.println("content: " + content);
    }

    /**
     * 将num转换为指定长度的数字，不足len位，前边补0
     *
     * @param num {@link Long}
     * @param len {@link Integer}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/12/30
     */
    public static String getNumAndAddPrefixZero(Long num, Integer len) {
        return String.format("%0" + len + "d", num);
    }

    @Test
    public void testGetNumAndAddPrefixZero() {
        System.out.println(getNumAndAddPrefixZero(18L, 3));
        System.out.println(getNumAndAddPrefixZero(1800L, 3));
        System.out.println(getNumAndAddPrefixZero(180L, 3));
        System.out.println(getNumAndAddPrefixZero(8L, 3));
    }

    @Test
    public void testSubstring2() {
        String str = "https://test-office.youmatech.com/cache/files/785409921022251008_3905/output.docx/https%3A%252f%252ftest-jiaofu.yuanzhiyijiantong.com%252fresources%252fserver-visit%252f%E5%B8%A6%E7%9C%8B%E5%8D%95%E6%A8%A1%E6%9D%BF.docx?md5=-A06XSPrw1HEOzs6mVSINw&expires=1676620289&disposition=attachment&filename=https%3A%252f%252ftest-jiaofu.yuanzhiyijiantong.com%252fresources%252fserver-visit%252f%E5%B8%A6%E7%9C%8B%E5%8D%95%E6%A8%A1%E6%9D%BF.docx";
        String ext = str.substring(str.lastIndexOf("."));
        System.out.println("ext = " + ext);
    }

    @Test
    public void testSubString3() {
        String msg = "【智客云】祝你生日快乐";
        String signName = msg.substring(1, msg.lastIndexOf("】"));
        String content = msg.substring(msg.lastIndexOf("】") + 1);

        System.out.println("signName = " + signName);
        System.out.println("content = " + content);
    }


}
