package top.kangyong.study02.design.pattern.creatormode.prototype.test;

/**
 * 原型模式
 * <p>
 * 克隆奖状案例：同一个学校的奖状只有姓名不同
 *
 * @author Kang Yong
 * @date 2022/10/17
 * @since 1.0.0
 */
public class Citation implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(name + "同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状，以资鼓励！");
    }
}
