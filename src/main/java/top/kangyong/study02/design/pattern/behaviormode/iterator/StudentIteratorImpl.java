package top.kangyong.study02.design.pattern.behaviormode.iterator;

import java.util.List;

/**
 * 具体迭代器角色类
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> list;
    private int position = 0; // 用来记录遍历时的位置

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        // 从集合中获取指定位置的元素
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }

}
