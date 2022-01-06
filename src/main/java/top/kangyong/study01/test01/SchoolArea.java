package top.kangyong.study01.test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/4/19 14:37
 * @version: v1.0
 */

public class SchoolArea {
    private String name;
    private Integer age;
    private Integer renci;

    public SchoolArea() {
    }

    public SchoolArea(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public SchoolArea(String name, Integer age, Integer renci) {
        this.name = name;
        this.age = age;
        this.renci = renci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRenci() {
        return renci;
    }

    public void setRenci(Integer renci) {
        this.renci = renci;
    }
}
