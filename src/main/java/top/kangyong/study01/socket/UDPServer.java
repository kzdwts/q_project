package top.kangyong.study01.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/3/29 18:17
 * @version: v1.0
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        // 创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 创建数据报
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 接收数据报
        socket.receive(packet);

        String info = new String(data, 0, data.length);
        System.out.println("我是服务端，客户端说：" + info);
    }
}
