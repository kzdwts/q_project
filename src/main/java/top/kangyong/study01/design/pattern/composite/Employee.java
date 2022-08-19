package top.kangyong.study01.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * @author Kang Yong
 * @date 2022/8/15
 * @since 1.0.0
 */
public class Employee {

    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<Employee>();
    }

    public void add(Employee employee) {
        this.subordinates.add(employee);
    }

    public void remove(Employee employee) {
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return this.subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
