package top.kangyong.study02.design.pattern.creatormode.singleton.demo7;

import java.io.*;

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

    public static void main(String[] args) throws Exception {
//        writeObject2File();

        readObjectFromFile();
        readObjectFromFile();

//        top.kangyong.study02.design.pattern.creatormode.singleton.demo7.Singleton@735f7ae5
//        top.kangyong.study02.design.pattern.creatormode.singleton.demo7.Singleton@180bc464

    }

    /**
     * 从文件读取数据（对象）
     *
     * @author Kang Yong
     * @date 2022/8/12
     */
    public static void readObjectFromFile() throws Exception {
        // 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\kangy\\Desktop\\tmp01.sql"));
        // 读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        // 释放资源
        ois.close();

    }

    /**
     * 向文件中写数据（对象）
     *
     * @author Kang Yong
     * @date 2022/8/12
     */
    public static void writeObject2File() throws IOException {
        // 创建单例对象
        Singleton instance = Singleton.getInstance();
        // 获取对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\kangy\\Desktop\\tmp01.sql"));
        // 写对象
        oos.writeObject(instance);

        // 释放资源
        oos.flush();
        oos.close();
    }
}
