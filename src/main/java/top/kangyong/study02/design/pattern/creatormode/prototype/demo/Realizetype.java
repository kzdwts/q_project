package top.kangyong.study02.design.pattern.creatormode.prototype.demo;

/**
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/10/17
 * @since 1.0.0
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型对象复制成功！");
        return (Realizetype) super.clone();
    }
}
