package top.kangyong.study01.iodemo.nio.file;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 通过nio实现io流
 * @author: Kang Yong
 * @date: 2021/9/1 22:27
 * @version: v1.0
 */
public class TestNIO {

    @Test
    public void test01() throws IOException {
        // 创建输出流
        FileOutputStream fos = new FileOutputStream("wanglili.txt");
        // 获取通道
        FileChannel channel = fos.getChannel();
        // 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 存数据
        buffer.put("Hello NIO".getBytes());
        buffer.flip();
        // 写出
        channel.write(buffer);
        fos.close();
    }

}
