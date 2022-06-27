package top.kangyong.study01.design.pattern.prototype;

/**
 * demo
 * <p>
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/6/27
 * @since 1.0.0
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape1 = ShapeCache.getShape("1");
        System.out.print(shape1);
        System.out.println("\t " + shape1.getType());

        Shape shape2 = ShapeCache.getShape("2");
        System.out.print(shape2);
        System.out.println("\t " + shape2.getType());

        Shape shape3 = ShapeCache.getShape("3");
        System.out.print(shape3);
        System.out.println("\t " + shape3.getType());

        Shape shape11 = ShapeCache.getShape("1");
        System.out.print(shape11);
        System.out.println("\t " + shape11.getType());

        Shape shape12 = ShapeCache.getShape("2");
        System.out.print(shape12);
        System.out.println("\t " + shape12.getType());

        Shape shape13 = ShapeCache.getShape("3");
        System.out.print(shape13);
        System.out.println("\t " + shape13.getType());
    }
}
