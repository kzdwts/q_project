package top.kangyong.study01.classlib;


import java.io.*;
//import org.gjt.jclasslib.io.ClassFileWriter;
//import org.gjt.jclasslib.structures.CPInfo;
//import org.gjt.jclasslib.structures.ClassFile;
//import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 处理class字节码文件
 * @author: kangyong
 * @date: 2020/9/1 9:34
 * @version: v1.0
 */
public class Demo01 {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\pc\\Desktop\\ems\\InvokenSendExServiceImpl.class";
        FileInputStream fis = new FileInputStream(filePath);

        DataInput di = new DataInputStream(fis);
    }

}
