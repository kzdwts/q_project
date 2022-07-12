package top.kangyong.study02.design.principles.liskov.after;

/**
 * 长方形
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/29
 * @since 1.0.0
 */
public class Rectangle implements Quadrilateral {

    private double length;

    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
