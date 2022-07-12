package top.kangyong.study02.design.principles.liskov.after;

/**
 * 四边形 接口
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/29
 * @since 1.0.0
 */
public interface Quadrilateral {

    /**
     * 获取长
     *
     * @return {@link double}
     * @author Kang Yong
     * @date 2022/6/29
     */
    double getLength();

    /**
     * 获取宽
     *
     * @return {@link double}
     * @author Kang Yong
     * @date 2022/6/29
     */
    double getWidth();
}
