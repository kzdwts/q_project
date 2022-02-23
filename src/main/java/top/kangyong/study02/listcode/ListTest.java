package top.kangyong.study02.listcode;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8操作list
 *
 * @author Kang Yong
 * @date 2022/2/22
 * @since 1.0.0
 */
public class ListTest {

    /**
     * 取出用户id集合
     *
     * @author Kang Yong
     * @date 2022/2/22
     */
    @Test
    public void test01() {
        List<Person> personList = new ArrayList<>(5);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 16, "钱梦婷"));
        personList.add(new Person(4, 1, 17, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));

        List<Integer> personIds = personList.stream().map(Person::getId).collect(Collectors.toList());
        personIds.forEach(System.out::println);

        personList.forEach(bean -> System.out.println(bean.getName()));
    }

    /**
     * 集合筛选
     * 取出 大于等于 18岁的人
     *
     * @author Kang Yong
     * @date 2022/2/23
     */
    @Test
    public void test02() {
        List<Person> personList = new ArrayList<>(5);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 16, "钱梦婷"));
        personList.add(new Person(4, 1, 17, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));

        List<Person> resultList = personList.stream().filter(bean -> bean.getAge() >= 18).collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
