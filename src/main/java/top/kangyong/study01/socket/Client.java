package top.kangyong.study01.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/3/24 22:34
 * @version: v1.0
 */
public class Client {

    public static void main(String[] args) {
        try {
            // 1、创建Socket
            Socket socket = new Socket("127.0.0.1", 8888);
            // 2、获取输出流，向服务端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：amdin;密码：123456");
            pw.flush();
            socket.shutdownOutput();

            // 3、接受服务端发来的消息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务端说：" + info);
            }

            // 4、关闭资源
            br.close();
            is.close();

            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
