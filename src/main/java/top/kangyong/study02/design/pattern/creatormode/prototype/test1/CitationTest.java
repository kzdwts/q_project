package top.kangyong.study02.design.pattern.creatormode.prototype.test1;

import java.io.*;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/18
 * @since 1.0.0
 */
public class CitationTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // 创建原型对象
        Citation citation = new Citation();
        Student stu = new Student();
        stu.setName("王丽丽");
        citation.setStu(stu);

        // 创建对象输入流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/data/a.txt"));
        // 写对象
        oos.writeObject(citation);
        oos.flush();
        oos.close();

        // 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/data/a.txt"));
        // 读取对象
        Citation citation1 = (Citation) ois.readObject();
        ois.close();

        Student stu1 = citation1.getStu();
        stu1.setName("张三");

        citation.show();
        citation1.show();

    }
}
