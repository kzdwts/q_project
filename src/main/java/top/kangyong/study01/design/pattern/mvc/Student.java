package top.kangyong.study01.design.pattern.mvc;

/**
 * 学生类
 * <p>
 * mvc模式
 *
 * @author Kang Yong
 * @date 2022/11/20
 * @since 1.0.0
 */
public class Student {

    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
