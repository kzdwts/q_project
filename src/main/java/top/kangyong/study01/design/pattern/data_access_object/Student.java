package top.kangyong.study01.design.pattern.data_access_object;

/**
 * 数值对象
 * <p>
 * 数据访问对象模式
 *
 * @author Kang Yong
 * @date 2022/12/3
 * @since 1.0.0
 */
public class Student {

    private String name;
    private Integer rollNo;

    public Student(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }
}
