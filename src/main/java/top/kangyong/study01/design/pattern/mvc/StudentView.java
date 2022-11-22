package top.kangyong.study01.design.pattern.mvc;

/**
 * mvc模式
 *
 * @author Kang Yong
 * @date 2022/11/20
 * @since 1.0.0
 */
public class StudentView {

    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student:");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Roll No: " + studentRollNo);
    }
}
