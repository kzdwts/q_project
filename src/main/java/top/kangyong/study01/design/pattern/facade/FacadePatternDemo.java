package top.kangyong.study01.design.pattern.facade;

/**
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/8/28
 * @since 1.0.0
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker sm = new ShapeMaker();

        sm.drawCircle();
        sm.drawRectangle();
        sm.drawSquare();

    }

}
