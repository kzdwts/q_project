package top.kangyong.study02.design.pattern.behaviormode.iterator;

/**
 * 抽象迭代器角色接口
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public interface StudentIterator {

    /**
     * 判断是否还有元素
     *
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2023/4/25
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return {@link Student}
     * @author Kang Yong
     * @date 2023/4/25
     */
    Student next();

}
