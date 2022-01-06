package top.kangyong.study01.design.pattern.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 工厂模式 正方形
 * @author: kangyong
 * @date: 2020/10/30 15:52
 * @version: v1.0
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("这是一个Square实例，画出了一个正方形");
    }

}
