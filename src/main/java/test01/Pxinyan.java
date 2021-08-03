package test01;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/3/26 11:53
 * @version: v1.0
 */
@Data
public class Pxinyan {
    private String name;

    private Integer age;

    public Pxinyan() {
    }

    public Pxinyan(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pxinyan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
