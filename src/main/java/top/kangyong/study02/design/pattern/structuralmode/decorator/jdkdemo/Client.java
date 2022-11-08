package top.kangyong.study02.design.pattern.structuralmode.decorator.jdkdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * jdk里面的BufferedWriter就是装饰者模式 实现
 * <p>
 * 装饰者模式：继承又聚合
 *
 * @author Kang Yong
 * @date 2022/11/8
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建FileWriter对象
        FileWriter fw = new FileWriter("C:\\Users\\kangy\\Desktop\\tmp.txt");
        // 创建BufferedWriter对象
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("hello buffered");

        bw.close();
        System.out.println("===over===");
    }
}
