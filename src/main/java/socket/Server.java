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
            Socket socket = null;

            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
