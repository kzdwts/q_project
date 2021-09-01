package iodemo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/9/1 21:17
 * @version: v1.0
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        while (true) {
            Socket s = new Socket("127.0.0.1", 9999);
            OutputStream os = s.getOutputStream();
            System.out.println("请输入：");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            os.write(msg.getBytes());

            // 读
            InputStream is = s.getInputStream();
            byte[] b = new byte[1024];
            is.read(b);
            System.out.println("老板说：" + new String(b).trim());
            // 关闭
            s.close();
        }
    }

}
