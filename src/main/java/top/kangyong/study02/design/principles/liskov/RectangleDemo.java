package top.kangyong.study02.design.principles.liskov;

/**
 * 测试类
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class RectangleDemo {

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setWidth(10);
        r.setLenght(20);
        resize(r);
        printLengthAndWidth(r);

        System.out.println("===华=丽=的=分=割=线===");

        Square s = new Square();
        s.setWidth(10);
        s.setLenght(20);
        // 死循环了，由此证明，正方形不是长方形（这种设计不符合里氏替换原则）
        resize(s);
        printLengthAndWidth(s);
    }

    public static void resize(Rectangle rectangle) {
        // 如果宽没有长大，就+1
        while (rectangle.getWidth() >= rectangle.getLenght()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Rectangle rectangle) {
        System.out.println("length:" + rectangle.getLenght());
        System.out.println("width:" + rectangle.getWidth());
    }
}
