package top.kangyong.study01.design.pattern.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 工厂模式 圆形
 * @author: kangyong
 * @date: 2020/10/30 15:56
 * @version: v1.0
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("这是一个Circle实例，画出了一个圆形");
    }

}
