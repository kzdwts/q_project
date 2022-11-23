package top.kangyong.study02.design.pattern.structuralmode.flyweight.jdk;

/**
 * Integer 用了享元模式 测试
 * <p>
 * 享元模式
 *
 * @author Kang Yong
 * @date 2022/11/23
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println("i1和i2对象是同一个对象吗 ？ " + (i1 == i2));
        System.out.println("i1.equals(i2) ? " + i1.equals(i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("i3和i4对象是同一个对象吗 ？ " + (i3 == i4));
        System.out.println("i3.equals(i4) ? " + i3.equals(i4));

    }

}
