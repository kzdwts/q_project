package top.kangyong.study02.design.pattern.creatormode.singleton.demo7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

/**
 * 序列化破坏单例模式
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/10
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        writeObject2File();

    }

    public static void writeObject2File() throws IOException {
        // 创建单例对象
        Singleton instance = Singleton.getInstance();
        // 获取对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\pc\\Desktop\\tmp01.txt"));
        // 写对象
        oos.writeObject(instance);

        // 释放资源
        oos.flush();
        oos.close();
    }
}
