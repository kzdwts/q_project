package top.kangyong.study02.design.pattern.creatormode.singleton.demo9;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * jdk 里面使用单例模式的Runtime 测试
 *
 * @author Kang Yong
 * @date 2022/8/20
 * @since 1.0.0
 */
public class RuntimeDemo {

    public static void main(String[] args) throws IOException {
        // 获取Runtime的对象
        Runtime runtime = Runtime.getRuntime();

        // 调用runtime的方法exec，参数要的是一个命令
        Process process = runtime.exec("ipconfig");

        InputStream is = process.getInputStream();

        byte[] bytes = new byte[1024];
        int len; // 读到的字节的个数
        while ((len = is.read(bytes)) > 0) {
            // 将字节数组转换为字符串输出到控制台
            System.out.println(new String(bytes, 0, len, "GBK"));
        }

        System.out.println("OVER");
    }
}
