package top.kangyong.study01.util;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/12/17 17:34
 * @version: v1.0
 */
public class ImageUtils {

    public static Boolean generateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) {
            return false;
        }

        BASE64Decoder decoder = new BASE64Decoder();


        try {
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            // 生成图片
            OutputStream os = new FileOutputStream(imgFilePath);
            os.write(bytes);
            os.flush();
            os.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//        // data:image/png;base64,
//
//        long cu = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            generateImage(imgStr, "D:\\output\\test" + i + ".jpg");
//        }
//        System.out.println(System.currentTimeMillis() - cu);
//    }

}