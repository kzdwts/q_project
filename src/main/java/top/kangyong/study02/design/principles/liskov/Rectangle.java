package top.kangyong.study02.design.principles.liskov;

/**
 * 长方形
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class Rectangle {

    /**
     * 长
     */
    private Integer lenght;

    /**
     * 宽
     */
    private Integer width;

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
