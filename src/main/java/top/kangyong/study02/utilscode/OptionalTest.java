package top.kangyong.study02.utilscode;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    /**
     * 测试ofNullAble else
     *
     * @author Kang Yong
     * @date 2022/6/8
     */
    @Test
    public void testOfNullAble() {
        Person person = Person.builder()
                .id(100)
                .name("咪咪噜")
                .build();
        Integer age = Optional.ofNullable(person.getAge()).orElse(22);
        System.out.println(age);
    }

    /**
     * 测试Optional.ofNullable针对Map.get空会不会报错
     *
     * @author Kang Yong
     * @date 2024/5/30
     */
    @Test
    public void testMapGet() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "张三丰"));
        personList.add(new Person(2, "张无忌"));
        personList.add(new Person(3, "赵敏"));

        Map<Integer, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        String personName = Optional.ofNullable(personMap.get(3)).map(Person::getName).orElse(null);
        // personName = 赵敏
        System.out.println("personName = " + personName);

        String personName2 = Optional.ofNullable(personMap.get(4)).map(Person::getName).orElse(null);
        // personName2 = null
        System.out.println("personName2 = " + personName2);

        String personName3 = personMap.getOrDefault(5, new Person()).getName();
        // personName3 = null
        System.out.println("personName3 = " + personName3);


    }

}
