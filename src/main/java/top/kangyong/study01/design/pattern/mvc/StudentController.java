package top.kangyong.study01.design.pattern.mvc;

/**
 * mvc模式
 *
 * @author Kang Yong
 * @date 2022/11/20
 * @since 1.0.0
 */
public class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
