package top.kangyong.study01.design.pattern.data_access_object;

import java.util.List;

/**
 * test
 * <p>
 * 数据访问对象模式
 *
 * @author Kang Yong
 * @date 2022/12/4
 * @since 1.0.0
 */
public class DaoPatternDemo {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> students = studentDao.getAllStudent();

        for (Student student : students) {
            System.out.println("Student rollNo:" + student.getRollNo() + "\tStudent name:" + student.getName());
        }

        System.out.println("=========================================");
        studentDao.updateStudent(new Student("Michael", 0));
        for (Student student : students) {
            System.out.println("Student rollNo:" + student.getRollNo() + "\tStudent name:" + student.getName());
        }

    }
}
