package top.kangyong.study01.design.pattern.bridge;

/**
 * demo
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/7/26
 * @since 1.0.0
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Circle greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

}
