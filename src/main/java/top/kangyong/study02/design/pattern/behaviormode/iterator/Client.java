package top.kangyong.study02.design.pattern.behaviormode.iterator;

/**
 * 迭代器模式测试
 * <p>
 * 行为型模式-迭代器模式
 *
 * 优点：
 * 1、支持不同的方式遍历一个聚合对象
 * 2、迭代器简化了聚合类
 * 3、引入了抽象层、满足“开闭原则”
 *
 * 缺点：
 * 1、增加系统复杂性
 *
 * 使用场景：
 * 1、当需要为聚合对象提供多种便利方式时
 * 2、当需要为遍历不同的聚合结构提供一个统一的接口时
 * 3、当访问一个聚合对象的内容而无需报漏其内部细节的表示
 *
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
