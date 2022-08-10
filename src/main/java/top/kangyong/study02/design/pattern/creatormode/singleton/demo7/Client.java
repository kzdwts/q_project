package top.kangyong.study02.design.pattern.creatormode.singleton.demo7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/8/10
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        writeObject2File();;
    }

    public static void writeObject2File() throws IOException {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\kangy\\Desktop\\tmp01.txt"));
        oos.writeObject(instance);
        oos.flush();
        oos.close();
    }
}
