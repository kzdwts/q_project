package top.kangyong.study02.design.pattern.behaviormode.iterator;

/**
 * 学生类
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public class Student {

    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String number;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
