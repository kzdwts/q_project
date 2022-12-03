package top.kangyong.study01.design.pattern.data_access_object;

import java.util.List;

/**
 * 数据访问对象接口
 * <p>
 * 数据访问对象模式
 *
 * @author Kang Yong
 * @date 2022/12/3
 * @since 1.0.0
 */
public interface StudentDao {

    /**
     * 查询学生列表
     *
     * @return {@link List< Student>}
     * @author Kang Yong
     * @date 2022/12/3
     */
    List<Student> getAllStudent();

    /**
     * 获取学生信息
     *
     * @param rollNo {@link Integer}
     * @return {@link Student}
     * @author Kang Yong
     * @date 2022/12/3
     */
    Student getStudent(Integer rollNo);

    /**
     * 更新学生信息
     *
     * @param student {@link Student}
     * @author Kang Yong
     * @date 2022/12/3
     */
    void updateStudent(Student student);

    /**
     * 删除学生信息
     *
     * @param student {@link Student}
     * @author Kang Yong
     * @date 2022/12/3
     */
    void deleteStudent(Student student);

}
