package top.kangyong.study02.design.pattern.behaviormode.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象聚合角色实现类
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student stu) {
        list.add(stu);
    }

    @Override
    public void removeStudent(Student stu) {
        for (Student s : list) {
            if (s.getName().equals(stu.getName())) {
                list.remove(stu);
                return;
            }
        }
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
