package top.kangyong.study02.design.pattern.structuralmode.flyweight;

/**
 * 抽象享元角色
 * <p>
 * 享元模式
 *
 * @author Kang Yong
 * @date 2022/11/17
 * @since 1.0.0
 */
public abstract class AbstractBox {

    /**
     * 获取图形
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/11/17
     */
    public abstract String getShape();

    public void display(String color) {
        System.out.println("形状：" + getShape() + "\t 颜色" + color);
    }
}
