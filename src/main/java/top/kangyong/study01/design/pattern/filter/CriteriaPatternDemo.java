package top.kangyong.study01.design.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * g过滤器模式
 *
 * @author Kang Yong
 * @date 2022/8/5
 * @since 1.0.0
 */
public class CriteriaPatternDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));
    }
}
