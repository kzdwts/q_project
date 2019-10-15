package test01;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: APP加密解密算法
 * @auther: kangyong
 * @date: 2019/3/26 17:31
 * @version: v1.0
 */
public class DES {

    public static final String KEY = "10086DES";

    private static byte[] IV = {1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * 加密
     *
     * @param encryptString
     * @param encryptKey
     * @return
     * @throws Exception
     */
    private static String encryptDES(String encryptString, String encryptKey) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(IV);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        return Base64.encode(encryptedData);
    }

    /**
     * 解密
     *
     * @param decryptString
     * @param decryptKey
     * @return
     * @throws Exception
     */
    private static String decryptDES(String decryptString, String decryptKey) throws Exception {
        byte[] byteMi = Base64.decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(IV);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        // 加密
        String encryptStr = encryptDES("phone=13469582666&provId=951", KEY);
        System.out.println(encryptStr);

        // 解密
        String decryptStr = decryptDES("fIM1EZHegX6EsWIP57Xag0yr/eLOYZCosCeDrOuiass=", KEY);
        System.out.println(decryptStr);
    }

}
