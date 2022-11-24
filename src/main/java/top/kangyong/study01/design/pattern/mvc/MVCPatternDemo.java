package top.kangyong.study01.design.pattern.mvc;

/**
 * test
 * <p>
 * mvc模式
 *
 * @author Kang Yong
 * @date 2022/11/22
 * @since 1.0.0
 */
public class MVCPatternDemo {

    public static void main(String[] args) {
        // 从数据库加载学生
        Student model = getStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // 更新模型数据
        controller.setStudentName("储小姣");

        controller.updateView();

    }

    private static Student getStudentFromDatabase() {
        Student student = new Student();
        student.setRollNo("1001");
        student.setName("王丽丽");
        return student;
    }
}
