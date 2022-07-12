package top.kangyong.study02.design.principles.liskov.after;

/**
 * 正方形 实现四边形的接口
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/29
 * @since 1.0.0
 */
public class Square implements Quadrilateral {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
