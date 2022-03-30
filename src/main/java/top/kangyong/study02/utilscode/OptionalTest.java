package top.kangyong.study02.utilscode;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 工具类测试
 *
 * @author Kang Yong
 * @date 2022/3/30
 * @since 1.0.0
 */
public class OptionalTest {

    //        List<Person> personList = new ArrayList<>(5);
//        personList.add(new Person(1, 0, 18, "王丽丽"));
//        personList.add(new Person(2, 1, 19, "储小姣"));
//        personList.add(new Person(5, 0, 16, "钱梦婷"));
//        personList.add(new Person(4, 1, 17, "徐慧文"));
//        personList.add(new Person(3, 0, 20, "张丹妮"));

    /**
     * 存在即返回，无则提供默认值
     *
     * @author Kang Yong
     * @date 2022/3/30
     */
    @Test
    public void orElseTestDemo() {
        Optional<String> a = Optional.ofNullable("");
        System.out.println(a);
    }

    /**
     * optional 工具类的初始化方法
     * 1. 介绍三种构造方式
     * 2. 主要区别是初始化传入参数是否允许为null
     * Optional.of 不允许为空
     * Optional.ofNullable 允许为空
     * Optional.empty 构建空Optional对象
     *
     * @author Kang Yong
     * @date 2022/3/30
     */
    @Test
    public void initTestDemo() {
        // 这种构造方式不能为null，否则会空指针异常
        Optional<Object> notNull = Optional.of(new Object());
        System.out.println("notNull:\t" + notNull);

        // 允许为空
        Optional<Object> nullAble = Optional.ofNullable(null);
        System.out.println("nullAble:\t" + nullAble);

        // 这种方式返回一个空的Optional，等效Optional.ofNullable(null)
        Optional<Object> empty = Optional.empty();
        System.out.println("empty:\t" + empty);
        System.out.println("empty.get():\t" + empty.get()); // 这种会报空指针
    }

}
