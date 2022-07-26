package top.kangyong.study01.design.pattern.filter;

/**
 * 过滤器模式
 *
 * @author Kang Yong
 * @date 2022/7/26
 * @since 1.0.0
 */
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
