package socket;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/3/29 17:13
 * @version: v1.0
 */
public class ServerThread extends Thread {

    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            // 获取输入流
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            // 读取客户端发送过来的信息
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务端，客户端说：" + info);
            }
            socket.shutdownInput();

            // 给客户端发消息
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎宁！");
            pw.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
