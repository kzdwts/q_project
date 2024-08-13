package top.kangyong.study02.md5utils;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import org.junit.Test;

/**
 * 测试加密
 *
 * @author Kang Yong
 * @date 2024/8/7
 * @since 1.0.0
 */
public class Md5UtilDemo {

    @Test
    public void md5Test() {
        String userName = "ztjwy";
        String password = "AHJQHtDiwr1a";
        long timestamp = System.currentTimeMillis();

        String sign = DigestUtil.md5Hex(userName + timestamp + DigestUtil.md5Hex(password));
        System.out.println("sign = " + sign);
        System.out.println("timestamp = " + timestamp);
    }
}
