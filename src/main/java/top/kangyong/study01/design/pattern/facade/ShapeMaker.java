package top.kangyong.study01.design.pattern.facade;

/**
 * 外观模式
 *
 * @author Kang Yong
 * @date 2022/8/28
 * @since 1.0.0
 */
public class ShapeMaker {

    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker(Shape circle, Shape rectangle, Shape square) {
        this.circle = circle;
        this.rectangle = rectangle;
        this.square = square;
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
