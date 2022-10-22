package top.kangyong.study02.design.pattern.creatormode.prototype.test1;

import java.io.Serializable;

/**
 * 原型模式：学生类
 *
 * @author Kang Yong
 * @date 2022/10/21
 * @since 1.0.0
 */
public class Student implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
