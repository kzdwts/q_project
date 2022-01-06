package top.kangyong.study01.iodemo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/9/1 21:17
 * @version: v1.0
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);

        while (true) {
            Socket s = ss.accept(); // 阻塞
            InputStream is = s.getInputStream();
            byte[] b = new byte[1024];
            is.read(b);
            String clientIp = s.getInetAddress().getHostAddress();
            System.out.println(clientIp + "说：" + new String(b).trim());

            // 返回
            OutputStream os = s.getOutputStream();
            os.write("没钱".getBytes());

            s.close();
        }
    }

}
