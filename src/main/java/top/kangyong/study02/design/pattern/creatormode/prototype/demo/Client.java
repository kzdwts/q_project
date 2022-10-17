package top.kangyong.study02.design.pattern.creatormode.prototype.demo;

/**
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/10/17
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        // n创建一个对象
        Realizetype realizetype = new Realizetype();

        // clone 一个对象
        Realizetype clone = realizetype.clone();

        System.out.println("原型对象和克隆出来的是否是同一个对象？" + (realizetype == clone));  // false
    }
}
