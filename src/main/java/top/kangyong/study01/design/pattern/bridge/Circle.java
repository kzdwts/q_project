package top.kangyong.study01.design.pattern.bridge;

/**
 * circle
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/7/26
 * @since 1.0.0
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
