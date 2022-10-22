package top.kangyong.study02.design.pattern.creatormode.prototype.test1;

import java.io.Serializable;

/**
 * 原型模式
 * <p>
 * 克隆奖状案例：同一个学校的奖状只有姓名不同
 *
 * @author Kang Yong
 * @date 2022/10/17
 * @since 1.0.0
 */
public class Citation implements Cloneable, Serializable {

    /*
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */

    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(stu.getName() + "同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状，以资鼓励！");
    }
}
