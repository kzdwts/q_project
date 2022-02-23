package top.kangyong.study02.listcode;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 集合去重 distinct用法
     *
     * @author Kang Yong
     * @date 2022/2/23
     */
    @Test
    public void test03() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 16, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 17, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));

        // distinct放在前面是对整个Person进行去重
        List<String> resultList = personList.stream().distinct().map(Person::getNationality).collect(Collectors.toList());
//        resultList.forEach(System.out::println);

        // distinct放在后边是对过滤后的nationality进行去重
        List<String> resultList2 = personList.stream().map(Person::getNationality).distinct().collect(Collectors.toList());
        resultList2.forEach(System.out::println);
    }

    /**
     * 基于anyMatch()判断条件至少匹配一个元素
     *
     * @author Kang Yong
     * @date 2022/2/23
     */
    @Test
    public void test04() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 16, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 17, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));

        // 至少有一个匹配，就返回true
        boolean flag = personList.stream().anyMatch(bean -> bean.getAge() > 18);
        if (flag) {
            System.out.println("集合中 有 年龄大于18的学生");
        } else {
            System.out.println("集合中 没嘛有 年龄大于18的学生");
        }
    }

    /**
     * 基于allMatch()判断条件是否匹配所有元素
     *
     * @author Kang Yong
     * @date 2022/2/23
     */
    @Test
    public void test05() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 16, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 17, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));

        // 至少有一个匹配，就返回true
        boolean flag = personList.stream().allMatch(bean -> bean.getAge() > 18);
        if (flag) {
            System.out.println("集合*所有*学生的年龄都大于18");
        } else {
            System.out.println("集合有年龄都小于18的学生");
        }
    }

    /**
     * ﬁndAny用于获取流中随机的某一个元素，并且利用短路在找到结果时，立即结束
     *
     * @author Kang Yong
     * @date 2022/2/23
     */
    @Test
    public void test06() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 16, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 17, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));

        // 找出性别为1的学生
        Stream<Person> personStream = personList.stream().filter(bean -> bean.getGender().intValue() == 1);
        Set<Person> personSet = personStream.collect(Collectors.toSet());
        for (Person person : personSet) {
            System.out.println(person.toString());
        }

        // ﬁndAny用于获取流中随机的某一个元素，并且利用短路在找到结果时，立即结束
        Optional<Person> personOptional = personList.stream().filter(bean -> bean.getGender().intValue() == 1).findAny();
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            System.out.println("===找出一个");
            System.out.println(person);
        }
    }
}
