package top.kangyong.study01.design.pattern.bridge;

/**
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/7/13
 * @since 1.0.0
 */
public interface DrawAPI {

    /**
     *画圆
     *
     * @param radius {@link int}
     * @param x      {@link int}
     * @param y      {@link int}
     * @author Kang Yong
     * @date 2022/7/13
     */
    void drawCircle(int radius, int x, int y);
}
