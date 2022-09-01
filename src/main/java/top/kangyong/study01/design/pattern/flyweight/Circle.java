package top.kangyong.study01.design.pattern.flyweight;

/**
 * 享元模式
 *
 * @author Kang Yong
 * @date 2022/9/1
 * @since 1.0.0
 */
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw():color:" + color + ", x:" + x + ", y:" + y + ", radius:" + radius);
    }
}
