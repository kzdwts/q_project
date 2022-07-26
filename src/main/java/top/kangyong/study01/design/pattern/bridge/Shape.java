package top.kangyong.study01.design.pattern.bridge;

/**
 * shape
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/7/26
 * @since 1.0.0
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
