package top.kangyong.study01.design.pattern.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 工厂模式 长方形
 * @author: kangyong
 * @date: 2020/10/30 15:50
 * @version: v1.0
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("这是一个Rectangle实例，画出了一个长方形");
    }

}
