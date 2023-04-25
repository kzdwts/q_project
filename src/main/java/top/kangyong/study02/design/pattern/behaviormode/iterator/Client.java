package top.kangyong.study02.design.pattern.behaviormode.iterator;

/**
 * 迭代器模式测试
 * <p>
 * 行为型模式-迭代器模式
 *
 * @author Kang Yong
 * @date 2023/4/25
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        aggregate.addStudent(new Student("张三", "001"));
        aggregate.addStudent(new Student("李四", "002"));
        aggregate.addStudent(new Student("王五", "003"));
        aggregate.addStudent(new Student("赵六", "004"));
        aggregate.addStudent(new Student("田七", "005"));

        // 获取迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            System.out.println("stu = " + stu);
        }

    }
}
