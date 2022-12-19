package top.kangyong.study01.design.pattern.transfer_object;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务对象
 * <p>
 * 传输对象模式
 *
 * @author Kang Yong
 * @date 2022/12/19
 * @since 1.0.0
 */
public class StudentBO {

    // 列表式当做一个数据库
    List<StudentVO> students;

    public StudentBO() {
        students = new ArrayList<>();
        StudentVO student1 = new StudentVO("Robot", 0);
        StudentVO student2 = new StudentVO("John", 1);
        students.add(student1);
        students.add(student2);
    }
}
