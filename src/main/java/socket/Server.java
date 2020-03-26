package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 模拟服务端
 * @author: kangyong
 * @date: 2020/3/24 22:34
 * @version: v1.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            // 1、创建ServerSocket
            ServerSocket serverSocket = new ServerSocket(8888);
            // 2、调用accept监听程序
            System.out.println("***服务器即将启动，等待客户端的链接***");
            Socket socket = serverSocket.accept();
            // 3、获取输入流
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            // 循环读取信息
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务端，客户端说：" + info);
            }
            socket.shutdownInput();

            // 4、向客户端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();

            // 5、关闭资源
            pw.close();
            os.close();

            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
