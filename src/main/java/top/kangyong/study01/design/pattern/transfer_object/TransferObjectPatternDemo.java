package top.kangyong.study01.design.pattern.transfer_object;

/**
 * 传输对象模式
 *
 * @author Kang Yong
 * @date 2022/12/21
 * @since 1.0.0
 */
public class TransferObjectPatternDemo {

    public static void main(String[] args) {
        StudentBO studentBusinessObject = new StudentBO();

        // 输出所有学生
        for (StudentVO student : studentBusinessObject.students) {
            System.out.println("student name: " + student.getName() + ", rollNo: " + student.getRoolNo());
        }
    }
}
