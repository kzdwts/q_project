package top.kangyong.study02.design.pattern.behaviormode.iterator;

/**
 * 抽象聚合角色接口
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public interface StudentAggregate {

    /**
     * 添加学生
     *
     * @param student {@link Student}
     * @author Kang Yong
     * @date 2023/4/25
     */
    void addStudent(Student student);

    /**
     * 删除学生
     *
     * @param student {@link Student}
     * @author Kang Yong
     * @date 2023/4/25
     */
    void removeStudent(Student student);

    /**
     * 获取迭代器对象
     *
     * @return {@link StudentIterator}
     * @author Kang Yong
     * @date 2023/4/25
     */
    StudentIterator getStudentIterator();

}
