package top.kangyong.study01.design.pattern.data_access_object;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现接口的实体
 * <p>
 * 数据访问对象模式
 *
 * @author Kang Yong
 * @date 2022/12/3
 * @since 1.0.0
 */
public class StudentDaoImpl implements StudentDao {

    private List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>();
        Student student1 = new Student("Robot", 0);
        Student student2 = new Student("John", 1);

        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }

    @Override
    public Student getStudent(Integer rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student rollNo:" + student.getRollNo() + " updated in the database");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student rollNo:" + student.getRollNo() + " deleted from database");
    }
}
