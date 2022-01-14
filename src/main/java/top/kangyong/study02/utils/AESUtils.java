package top.kangyong.study02.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import top.kangyong.study02.model.Person;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.*;

/**
 * AES加密
 *
 * @author Kang Yong
 * @date 2022/1/14
 * @since 1.0.0
 */
public class AESUtils {

    static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();

    public static String timestampSign(Map<String, Object> paramMap, String secret, String timestamp) {
        if ((!Objects.isNull(paramMap) || !paramMap.isEmpty()) && !StringUtils.isEmpty(secret) && !StringUtils.isEmpty(timestamp)) {
            String params = sortParams(paramMap, timestamp);
            if (StringUtils.isEmpty(params)) {
                return "";
            } else {
                try {
                    return sign(params, secret);
                } catch (Throwable var5) {
                    throw new RuntimeException("AesUtils[timestampSign] generated sign error", var5);
                }
            }
        } else {
            return "";
        }
    }

    public static String sign(String params, String secret) throws Throwable {
        byte[] bytes = hmacSHA1Encrypt(params, secret);
        byte[] encode = BASE64_ENCODER.encode(bytes);
        return URLEncoder.encode(new String(encode), "UTF-8");
    }

    public static byte[] hmacSHA1Encrypt(String encryptText, String encryptKey) throws Throwable {
        byte[] data = encryptKey.getBytes("UTF-8");
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] text = encryptText.getBytes("UTF-8");
        return mac.doFinal(text);
    }

    public static String sortParams(Map<String, Object> params, String timestamp) {
        if (CollectionUtils.isEmpty(params)) {
            return "";
        } else {
            params.values().removeIf(StringUtils::isEmpty);
            TreeMap<String, Object> treeMap = new TreeMap(new Comparator<String>() {
                public int compare(String obj1, String obj2) {
                    return obj1.compareTo(obj2);
                }
            });
            treeMap.putAll(params);
            StringBuffer sbf = new StringBuffer();
            Iterator var4 = treeMap.entrySet().iterator();

            while (var4.hasNext()) {
                Map.Entry<String, Object> paramEntry = (Map.Entry) var4.next();
                sbf.append((String) paramEntry.getKey()).append("=").append(paramEntry.getValue()).append("&");
            }

            return sbf.append("timestamp").append("=").append(timestamp).toString();
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("测试");
        person.setGender(1);
        person.setAge(18);
        person.setWeight(128.5f);
        String str = JSONObject.toJSONString(person);
        String s = timestampSign(JSONObject.parseObject(str), "af27ddb5e33cea7d6ad0dfe9ceed0d09", "20211230110615");
        System.out.println(s);

    }
}
