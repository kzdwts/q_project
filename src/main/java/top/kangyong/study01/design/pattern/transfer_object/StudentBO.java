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

    /**
     * 删除一个学生
     *
     * @param student {@link StudentVO}
     * @author Kang Yong
     * @date 2022/12/19
     */
    public void deleteStudent(StudentVO student) {
        students.remove(student.getRoolNo());
        System.out.println("Student: roll no " + student.getRoolNo() + ", deleted from database");
    }

    /**
     * 从数据库中检索学生名单
     *
     * @return {@link List< StudentVO>}
     * @author Kang Yong
     * @date 2022/12/19
     */
    public List<StudentVO> getAllStudents() {
        return students;
    }

    /**
     * 根据学号获取学生信息
     *
     * @param rollNo {@link int}
     * @return {@link StudentVO}
     * @author Kang Yong
     * @date 2022/12/19
     */
    public StudentVO getStudent(int rollNo) {
        return students.get(rollNo);
    }

    /**
     * 更新学生信息
     *
     * @param student {@link StudentVO}
     * @author Kang Yong
     * @date 2022/12/19
     */
    public void updateStudent(StudentVO student) {
        students.get(student.getRoolNo()).setName(student.getName());
        System.out.println("Student: roll no " + student.getRoolNo() + ", updated in thr database");
    }


}
