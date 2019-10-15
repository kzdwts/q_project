package test01;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @auther: kangyong
 * @date: 2019/3/27 14:16
 * @version: v1.0
 */
public class Wechat {

    /**
     * 解密
     *
     * @param provId
     * @param content
     * @param sign
     * @param channel
     * @param timestamp
     * @return
     */
    public static String decode(String provId, String content, String sign, String channel, String timestamp) throws Exception {
        String msg = "wmhMultiSSO" + channel + timestamp + content;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(msg.getBytes());

        String tempsign = new BASE64Encoder().encode(md5.digest()).toUpperCase();

        if (sign.equals(tempsign)) {
            System.out.println("验签成功");
            String key = "9f2a628228aa44eaa8eaa8ef9a53b3427377";
            byte[] bytes = new BASE64Decoder().decodeBuffer(content);

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kgen.init(128, random);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
            byte[] decryptBytes = cipher.doFinal(bytes);
            String userInfo = new String(decryptBytes);
            System.out.println("解密得到的用户信息" + userInfo);
        }
        return null;
    }

    /**
     * 加密
     * @param phone
     * @param userId
     * @return
     */
    public String encode(String phone, String userId) throws Exception {
        // 处理字符串
        StringBuilder sb = new StringBuilder();
        sb.append("phone=" + phone);
        sb.append("&");
        sb.append("userId=" + userId);

        //
//        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
//        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
//        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
//
//        // BASE64加密
//        return Base64.encode(encryptedData);
        return null;

    }


    public static void main(String[] args) throws Exception {
        String content="3SnrO46CUDZYl1xrVrM54XQ4KXyYWqpm3QMrteumjShKUpKoUb/Ia2bpE8XLHDW5";
        String key = "9f2a628228aa44eaa8ef9a53b3427377";
        byte[] bytes = new BASE64Decoder().decodeBuffer(content);

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(128, random);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(bytes);
        String userInfo = new String(decryptBytes);
        System.out.println(userInfo);
    }

}
