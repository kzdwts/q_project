package demo;

import org.junit.Test;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/5/25 14:30
 * @version: v1.0
 */
public class Demo05 {

    private Base64.Decoder decoder = Base64.getDecoder();
    private Base64.Encoder encoder = Base64.getEncoder();

    @Test
    public void test01() throws UnsupportedEncodingException {
//        { "rawData1": "aA==", "rawData2Length": 33, "rawData2": "AAAAGkBdU4IVYCsrQD/grWtPSwlCtNIiAEBm7wIBLRC5" }
        String text = "01";
        // 编码
        String encodedText = encoder.encodeToString(text.getBytes("UTF-8"));
        System.out.println(encodedText);

        // 解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

    @Test
    public void test02() throws UnsupportedEncodingException {
        byte[] buffers = new byte[]{01};
        String encodedText = encoder.encodeToString(buffers);
        System.out.println(encodedText);
        byte[] decodeBytes = decoder.decode(encodedText);
        String decodeText = Arrays.toString(decodeBytes);
        System.out.println(decodeText);

        String s = encoder.encodeToString(decodeText.getBytes("UTF-8"));
        System.out.println(s);
    }

    @Test
    public void base64EncodeTest() throws UnsupportedEncodingException {
        String text = "01";
        String encodedText = encoder.encodeToString(text.getBytes("UTF-8"));
        System.out.println(encodedText);
    }

    /**
     * 解析数据
     *
     * @param text
     */
    public void decodeRawData1(String text) {
        byte[] decodeByte = decoder.decode(text);
        String decodeText = Arrays.toString(decodeByte);
        System.out.println(decodeByte.length + "" + decodeText);
    }

    @Test
    public void decodeData1() {
        decodeRawData1("aA==");
        decodeRawData1("33");
        decodeRawData1("AAAAGkBdU4IVYCsrQD/grWtPSwlCtNIiAEBm7wIBLRC5");
    }

    @Test
    public void encodeData1() throws UnsupportedEncodingException {
        String text = "0000001a0000000000000000000000000000000042858f4f0000000000012d1086";

    }

    @Test
    public void toHex() {
//       104 → 68
//       33  → 21

        String s = Integer.toHexString(33);
        System.out.println(s);
    }


}
