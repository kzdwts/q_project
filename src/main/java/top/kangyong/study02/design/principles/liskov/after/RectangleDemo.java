package top.kangyong.study02.design.principles.liskov.after;

import top.kangyong.study02.design.principles.liskov.before.Square;

/**
 * 测试类
 *
 * @author Kang Yong
 * @date 2022/6/29
 * @since 1.0.0
 */
public class RectangleDemo {

    public static void main(String[] args) {
       Rectangle r = new Rectangle();
        r.setWidth(10);
        r.setLength(20);
        resize(r);
        printLengthAndWidth(r);

        System.out.println("===华=丽=的=分=割=线===");

    }

    /**
     * 扩宽
     *
     * @param rectangle {@link Rectangle}
     * @author Kang Yong
     * @date 2022/6/29
     */
    public static void resize(Rectangle rectangle) {
        // 如果宽没有长大，就+1
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    /**
     * 打印长和宽
     *
     * @param quadrilateral {@link Quadrilateral}
     * @author Kang Yong
     * @date 2022/6/29
     */
    public static void printLengthAndWidth(Quadrilateral quadrilateral) {
        System.out.println(quadrilateral.getLength());
        System.out.println(quadrilateral.getWidth());
    }
}
