package top.kangyong.study02.listcode;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import top.kangyong.study02.model.Person;
import top.kangyong.study02.model.UserDTO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
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
//        resultList2.forEach(System.out::println);

        List<Person> resultList3 = personList.stream().distinct().collect(Collectors.toList());
        resultList3.forEach(System.out::println);
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
        // 此处是串行，所以暂时没遇见随机获取，暂时取得都是第一个
        System.out.println("===找出一个");
        for (int i = 0; i < 1000; i++) {
            Optional<Person> personOptional = personList.stream().filter(bean -> bean.getGender().intValue() == 1).findAny();
            if (personOptional.isPresent()) {
                Person person = personOptional.get();
                System.out.println(person);
            }
        }
    }

    /**
     * List<Object>根据某个字段分组
     * 根据年龄分组
     *
     * @author Kang Yong
     * @date 2022/2/24
     */
    @Test
    public void test07() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 19, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 18, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(6, 0, 20, "陆之昂", "中国"));

        Map<Integer, List<Person>> ageGroupPerson = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        for (Map.Entry<Integer, List<Person>> entry : ageGroupPerson.entrySet()) {
            Integer age = entry.getKey();
            List<Person> peoples = entry.getValue();
            System.out.println(age + " 岁的有：");
            for (Person people : peoples) {
                System.out.println(people);
            }
        }
    }

    /**
     * List<Object>提取数据
     *
     * @author Kang Yong
     * @date 2022/3/4
     */
    @Test
    public void test08() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 19, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 18, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(6, 0, 20, "陆之昂", "中国"));

        Map<String, Integer> personMap = personList.stream().collect(Collectors.toMap(Person::getName, Person::getGender));
        for (Map.Entry<String, Integer> entries : personMap.entrySet()) {
            System.out.println(entries.getKey() + ": " + entries.getValue());
        }
    }

    /**
     * 提取List数据转为map，并将字段根据枚举转义
     *
     * @author Kang Yong
     * @date 2022/3/4
     */
    @Test
    public void test09() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 19, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 18, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(6, 0, 20, "陆之昂", "中国"));

        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(Person::getName, bean -> {
            // 性别：0女，1男，2未知
            if (bean.getGender().equals(1)) {
                return "男孩";
            } else if (bean.getGender().equals(0)) {
                return "女孩";
            }
            return "未知";
        }));
        for (Map.Entry<String, String> entries : personMap.entrySet()) {
            System.out.println(entries.getKey() + ": " + entries.getValue());
        }
    }

    /**
     * 测试addAll
     *
     * @author Kang Yong
     * @date 2022/3/22
     */
    @Test
    public void test10() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", "中国"));
        personList.add(new Person(2, 1, 19, "储小姣", "美国"));
        personList.add(new Person(5, 0, 19, "钱梦婷", "中国"));
        personList.add(new Person(4, 1, 18, "徐慧文", "日本"));
        personList.add(new Person(3, 0, 20, "张丹妮", "中国"));
        personList.add(new Person(6, 0, 20, "陆之昂", "中国"));

        List<Integer> numList = new ArrayList<>();
        numList.add(100);
        numList.addAll(personList.stream().map(Person::getId).distinct().collect(Collectors.toList()));
        numList.add(200);

        numList.forEach(System.out::println);
    }

    @Test
    public void test11() {
        BigDecimal b1 = new BigDecimal(100.00);
        BigDecimal b2 = new BigDecimal(-111.00);
        BigDecimal b3 = new BigDecimal(0.03);
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", b1));
        personList.add(new Person(2, 1, 19, "储小姣", b2));
        personList.add(new Person(5, 0, 19, "钱梦婷", b3));
        personList.add(new Person(4, 1, 18, "徐慧文", b1));
        personList.add(new Person(3, 0, 20, "张丹妮", b2));
        personList.add(new Person(6, 0, 20, "陆之昂", b3));

        List<Person> resultList = personList.stream().distinct().filter(item -> {
            if (Objects.nonNull(item.getMoney()) && (item.getMoney().compareTo(BigDecimal.ZERO) > 0)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        resultList.forEach(System.out::println);
    }

    /**
     * list转map
     * 格式：id（key） → 对象（value）
     *
     * @author Kang Yong
     * @date 2022/5/23
     */
    @Test
    public void test12() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));

        Map<Integer, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        System.out.println(personMap.size());
    }

    /**
     * 创建list集合
     *
     * @author Kang Yong
     * @date 2022/5/25
     */
    @Test
    public void test13() {
//        List<Integer> numList = Arrays.stream(new Integer[]{}).distinct().collect(Collectors.toList());
//        List<Integer> numList = Arrays.stream(new Integer[]{
//                1,
//                null,
//                null,
//                2
//        }).distinct().collect(Collectors.toList());

        List<Integer> numList = new ArrayList<>();

        System.out.println(CollectionUtils.isEmpty(numList));
        System.out.println(numList.size());
        numList.forEach(System.out::println);
    }

    @Test
    public void test14() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, ""));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, null));

        List<String> nameList = personList.stream().map(Person::getName).filter(Objects::nonNull).collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }

    @Test
    public void test15() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, ""));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, null));

        List<String> nameList = personList.stream().map(Person::getName).filter(StringUtils::isNotBlank).collect(Collectors.toList());
        nameList.forEach(System.out::println);


        List<Integer> personIds = personList.stream().map(Person::getId).collect(Collectors.toList());
        personIds.removeIf(bean -> bean.equals(1));
        personIds.forEach(System.out::println);

    }

    @Test
    public void test16() {

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("name", "王丽丽");
        m1.put("age", 18);
        m1.put("weight", 65.8);
        Map<String, Object> m2 = new HashMap<>();
        m2.put("name", "徐慧文");
        m2.put("age", 28);
        m2.put("weight", 64.8);
        list.add(m1);
        list.add(m2);

        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("===");
        }

        String tb = "schema.column";

        List<String> keyList = new ArrayList<>();
        List<Map<String, Object>> objList = new ArrayList<>();
        for (Map<String, Object> objectMap : list) {
            Map<String, Object> tmpMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                String key = tb + "." + entry.getKey();
                tmpMap.put(key, entry.getValue());
                keyList.add(key);
            }
            objList.add(tmpMap);
        }

        System.out.println("=================");

        for (Map<String, Object> map : objList) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("===");
        }

        System.out.println("所有的key===");
        keyList.forEach(System.out::println);

        Map<String, Object> resultMap = new HashMap<>();
        for (String key : keyList) {
            resultMap.put(key, objList);
        }

        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + "::::");
            System.out.println(entry.getValue());
        }

    }

    /**
     * 将List<Person> 转为 Map<Integer, List<String>>
     * 即将person集合转为 map:年龄 → List<姓名>
     *
     * @author Kang Yong
     * @date 2022/9/21
     */
    @Test
    public void test17() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));

        Map<Integer, List<String>> ageNameMap = personList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(JSON.toJSONString(ageNameMap));
    }

    @Test
    public void testListGroupByColumons() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));
        personList.add(new Person(6, 0, 20, "陆之昂"));
        personList.add(new Person(6, 1, 20, "陆之昂"));
        personList.add(new Person(6, 1, 20, null));

        Map<String, List<Person>> listMap = personList.stream().collect(Collectors.groupingBy(p -> p.getGender() + "-" + p.getName()));
        Set<String> keySet = listMap.keySet();
        for (String s : keySet) {
            System.out.println("s = " + s);
        }

        System.out.println(personList);
    }

    @Test
    public void testListRemove() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));

        System.out.println(personList);
    }

    @Test
    public void testListRemove2() {
        List<Long> tIdList = new ArrayList<>();
        tIdList.add(111L);
        tIdList.add(222L);
        tIdList.add(333L);
        tIdList.add(444L);
        System.out.println("tIdList = " + tIdList);

        boolean rb = tIdList.remove(222L);
        System.out.println("rb = " + rb);
        System.out.println("tIdList = " + tIdList);

        boolean rb2 = tIdList.remove(888L);
        System.out.println("rb2 = " + rb2);

        boolean rb3 = tIdList.remove(111L);
        tIdList.remove(333L);
        tIdList.remove(444L);

        System.out.println("tIdList = " + tIdList);
        System.out.println("CollectionUtils.isEmpty(tIdList) = " + CollectionUtils.isEmpty(tIdList));
    }

    /**
     * 测试多次addAll
     *
     * @author Kang Yong
     * @date 2022/10/17
     */
    @Test
    public void testAddAll() {
        List<Person> allGrilList = new ArrayList<>();
        List<Person> p1List = new ArrayList<>();
        p1List.add(new Person(5, 0, 19, "钱梦婷"));
        allGrilList.addAll(p1List);

        List<Person> p2List = new ArrayList<>();
        p2List.add(new Person(5, 0, 19, "柯丽妮"));
        p2List.add(new Person(5, 0, 19, "郭雯艳"));
        p2List.add(new Person(5, 0, 19, "葛艳红"));
        p2List.add(new Person(5, 0, 19, "洋洋月"));
        p2List.add(new Person(3, 0, 20, "张丹妮"));
        allGrilList.addAll(p2List);

        List<Person> p3List = new ArrayList<>();
        p3List.add(new Person(1, 0, 18, "王丽丽"));
        p3List.add(new Person(2, 1, 19, "储小姣"));
        allGrilList.addAll(p3List);

        List<Person> p4List = new ArrayList<>();
        p4List.add(new Person(4, 1, 18, "徐慧文"));
        p4List.add(new Person(6, 0, 20, "陆之昂"));
        allGrilList.addAll(p4List);

        allGrilList.forEach(System.out::println);
    }

    /**
     * 测试空列表 Collections.emptyList()
     *
     * @author Kang Yong
     * @date 2022/10/26
     */
    @Test
    public void testEmptyList() {
        List<Person> personList = Collections.emptyList();
        System.out.println("personList.size(): " + personList.size());

        for (Person person : personList) {
            System.out.println("item: " + person);
        }
        System.out.println("===over===");
        System.out.println(CollectionUtils.isEmpty(personList));
    }

    /**
     * 测试空列表 Collections.emptyList() add()方法
     *
     * @author Kang Yong
     * @date 2022/12/28
     */
    @Test
    public void testEmptyListAdd() {
        List<Person> personList = new ArrayList<>();
        System.out.println("personList.size(): " + personList.size());

        for (Person person : personList) {
            System.out.println("item: " + person);
        }
        System.out.println("===ing===");
        System.out.println(CollectionUtils.isEmpty(personList));

        // add
        personList.add(new Person(1, "王丽丽"));
        for (Person person : personList) {
            System.out.println("item: " + person);
        }
        System.out.println("===over===");
        System.out.println(CollectionUtils.isEmpty(personList));

    }

    /**
     * 测试空集合的add方法
     *
     * @author Kang Yong
     * @date 2024/7/10
     */
    @Test
    public void testEmptyListAdd2() {
        List<Person> personList = Collections.emptyList();

        personList.add(new Person(1, "王丽丽"));

        System.out.println("===over===");
        System.out.println(CollectionUtils.isEmpty(personList));
        System.out.println("JSON.toJSONString(personList) = " + JSON.toJSONString(personList));

        /* 这么写会报错
        java.lang.UnsupportedOperationException
	at java.util.AbstractList.add(AbstractList.java:148)
	at java.util.AbstractList.add(AbstractList.java:108)
	at top.kangyong.study02.listcode.ListTest.testEmptyListAdd2(ListTest.java:620)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater$1.execute(IdeaTestRunner.java:38)
	at com.intellij.rt.execution.junit.TestsRepeater.repeat(TestsRepeater.java:11)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:35)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:232)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:55)
         */
    }

    @Test
    public void testReAdd() {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person(5, 0, 19, "钱梦婷");
        Person p2 = new Person(9, 0, 23, "蚊子");
        Person p3 = new Person(9, 0, 23, "蚊子");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        System.out.println(personList.size());
        System.out.println(personList);

        List<Person> list2 = personList.stream().distinct().collect(Collectors.toList());
        System.out.println(list2.size());
        System.out.println(list2);
    }

    @Test
    public void testReAdd2() {
        List<String> nameList = new ArrayList<>();
        nameList.add("蚊子");
        nameList.add("蚊子");
        nameList.add("小康");

        System.out.println(nameList.size());
        System.out.println(nameList);

        nameList = nameList.stream().distinct().collect(Collectors.toList());
        System.out.println(nameList.size());
        System.out.println(nameList);
    }

    @Test
    public void testReAddSet() {
        Set<String> nameList = new HashSet<>();
        nameList.add("蚊子");
        nameList.add("九黎小");
        nameList.add("蚊子");

        System.out.println(nameList.size());
        System.out.println(nameList);

        nameList = nameList.stream().distinct().collect(Collectors.toSet());
        System.out.println(nameList.size());
        System.out.println(nameList);

    }

    @Test
    public void testJoin() {
        List<String> nameList = new ArrayList<>();
        nameList.add("王小丽,牛丽丽");
        nameList.add("胡明丽");
        nameList.add("康康,姆瑞尔");
        nameList.add("间,迈克尔");

        String joinStr = String.join(",", nameList);
        System.out.println(joinStr);
    }

    /**
     * 测试list sum方法
     *
     * @author Kang Yong
     * @date 2022/11/5
     */
    @Test
    public void testSum() {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person(5, 0, 19, "钱梦婷");
        Person p2 = new Person(9, 0, 23, "蚊子");
        Person p3 = new Person(9, 0, 23, "栗栗");
//        Person p4 = new Person(9, 0, 1, "惠子");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
//        personList.add(p4);

        long count = personList.stream().map(Person::getAge).count();  // 3 count数量
        System.out.println("count:" + count);

        long sum = personList.stream().mapToLong(Person::getAge).sum(); // 65 sum累加
        System.out.println("sum: " + sum);
    }

    /**
     * 集合合并
     *
     * @author Kang Yong
     * @date 2022/11/24
     */
    @Test
    public void mergeList() {
        List<Integer> aList = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> bList = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> abAllList = new ArrayList<>();
        abAllList.addAll(aList);
        abAllList.addAll(bList);

        System.out.println(abAllList);
    }

    /**
     * List做队列
     *
     * @author Kang Yong
     * @date 2022/11/29
     */
    @Test
    public void ListAddAndRemove() {
        List<String> list = initList();
        System.out.println("初始化数据：" + list);

        // 第一次获取
        System.out.println("====第一次获取");
        String str = getOne(list);
        System.out.println(str);

        System.out.println(list);

        // 第二次获取
        System.out.println("====第二次获取");
        String str2 = getOne(list);
        System.out.println(str2);

        System.out.println(list);

    }

    private String getOne(List<String> list) {
        String s = list.get(0);
        list.remove(0);
        list.add(s);
        return s;
    }

    public static List<String> initList() {
        List<String> abcList = new ArrayList<>();
        abcList.add("A");
        abcList.add("B");
        abcList.add("C");
        abcList.add("D");
        return abcList;
    }

    /**
     * 测试list去重
     *
     * @author Kang Yong
     * @date 2022/12/28
     */
    @Test
    public void testDistinct() {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(3);
        numList.add(5);
        numList.addAll(Arrays.asList(1, 5, 6, 8));

        numList.forEach(System.out::println);

        System.out.println("==========华丽的分割线=============");
        Set<Integer> setNumList = new HashSet<>();
        setNumList.add(11);
        setNumList.add(13);
        setNumList.add(15);

        Set<Integer> tmpSetList = new HashSet<>();
        tmpSetList.add(11);
        tmpSetList.add(15);
        tmpSetList.add(19);
        setNumList.addAll(tmpSetList);

        setNumList.forEach(System.out::println);

    }

    /**
     * List转数组
     *
     * @author Kang Yong
     * @date 2022/12/30
     */
    @Test
    public void testListToArray() {
        List<String> uuidList = new ArrayList<>(5);
        for (int i = 5; i > 0; i--) {
            uuidList.add(UUID.randomUUID().toString());
        }

        String[] uuidArr = uuidList.toArray(new String[uuidList.size()]);
        for (int i = 0; i < uuidArr.length; i++) {
            System.out.println(uuidArr[i]);
        }
    }

    /**
     * 数组转List
     *
     * @author Kang Yong
     * @date 2022/12/30
     */
    @Test
    public void testArrayToList() {
        String[] uuidArray = new String[5];
        for (int i = 0; i < 5; i++) {
            uuidArray[i] = UUID.randomUUID().toString();
        }

        List<String> uuidList = Arrays.asList(uuidArray);
        uuidList.forEach(System.out::println);
    }

    /**
     * list 求交集
     *
     * @author Kang Yong
     * @date 2023/4/6
     */
    @Test
    public void retailAllTest() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 9, 4, 5, 6, 7));

        list1.retainAll(list2);
        System.out.println("list1 = " + list1); // 输出list1 = [4, 5, 6]
    }

    /**
     * List<String>转为List<Integer>
     *
     * @author Kang Yong
     * @date 2023/4/10
     */
    @Test
    public void ListString2ListInteger() {
        String idStr = "1,3,5,6,7,110,1234";
        List<String> idStrList = Arrays.asList(idStr.split(","));
        List<Integer> idList = idStrList.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(idList);
    }

    /**
     * List copy test 浅拷贝
     *
     * @author Kang Yong
     * @date 2023/6/1
     */
    @Test
    public void listCopyTest1() {

        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1, "林青霞"));
        pList.add(new Person(2, "赵敏"));
        System.out.println("pList = " + pList);

        List<Person> list2 = new ArrayList<>();
        // 不做这一步赋值会报错 `java.lang.IndexOutOfBoundsException: Source does not fit in dest`
        for (Person person : pList) {
            list2.add(null);
        }

        Collections.copy(list2, pList);
        System.out.println("list2 = " + list2);
        System.out.println("=======华丽的分割线======");

//        Collections.copy是浅拷贝，list1的10个元素，和list2的10个元素，是一样的，修改其中一边的，另一边跟着改（因为是同一个引用）
        pList.get(0).setAge(18);
        System.out.println("pList = " + pList);
        System.out.println("list2 = " + list2);

//        浅拷贝的话，list2是用new语句创建出来的新的对象，因此list1和list2两个对象不相等，
        System.out.println("list2 == pList: " + (list2 == pList));
    }

    /**
     * List copy test 浅拷贝
     *
     * @author Kang Yong
     * @date 2023/6/2
     */
    @Test
    public void listCopyTest2() {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1, "林青霞"));
        pList.add(new Person(2, "赵敏"));
        System.out.println("pList = " + pList);

        List<Person> list2 = new ArrayList<>(pList);

        System.out.println("pList = " + pList);
        System.out.println("list2 = " + list2);

    }

    /**
     * List copy test 深拷贝
     *
     * @author Kang Yong
     * @date 2023/6/2
     */
    @Test
    public void listCopyTest3() {
        // 初始化数据
        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1, "林青霞"));
        pList.add(new Person(2, "赵敏"));
        System.out.println("pList = " + pList);

        // 使用orika复制工具: 集合复制使用mapAsList，对象复制使用map
        MapperFactory mf = new DefaultMapperFactory.Builder().build();
        List<Person> personList = mf.getMapperFacade().mapAsList(pList, Person.class);
        System.out.println("personList = " + personList);

        // 更新一下试试
        pList.get(0).setName("张无忌");
        System.out.println("pList = " + pList);
        System.out.println("personList = " + personList);

    }

    /**
     * List copy test use json
     *
     * @author Kang Yong
     * @date 2023/6/2
     */
    @Test
    public void listCopyTest4() {
        // 初始化数据
        List<Person> pList = new ArrayList<>();
        pList.add(new Person(1, "林青霞"));
        pList.add(new Person(2, "赵敏"));
        System.out.println("pList = " + pList);

        String jsonStr = JSON.toJSONString(pList);
        List<Person> personList = JSON.parseArray(jsonStr, Person.class);

        System.out.println("personList = " + personList);
    }

    @Test
    public void findFirstTest() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));

        Person person18 = personList.stream().filter(b -> b.getAge().equals(18)).findFirst().orElse(null);
        Person person21 = personList.stream().filter(b -> b.getAge().equals(21)).findFirst().orElse(null);

        System.out.println("person18 = " + person18);
        System.out.println("person21 = " + person21);
    }

    @Test
    public void newEmptyListTest() {
        List<Person> personList = new ArrayList();

        List<Person> pList = personList.stream().filter(b -> b.getAge() == 18).collect(Collectors.toList());
        System.out.println("pList.size() = " + pList.size());

        System.out.println("CollectionUtils.isEmpty(pList) = " + CollectionUtils.isEmpty(pList));
    }

    /**
     * List转Map，多个字段拼接为key
     */
    @Test
    public void multColumeJoin2Key() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽"));
        personList.add(new Person(2, 1, 19, "储小姣"));
        personList.add(new Person(5, 0, 19, "钱梦婷"));
        personList.add(new Person(4, 1, 18, "徐慧文"));
        personList.add(new Person(3, 0, 20, "张丹妮"));
        personList.add(new Person(6, 0, 20, "陆之昂"));


        Map<String, Person> collect = personList.stream().collect(Collectors.toMap(bean -> {
            return String.join("-", bean.getId().toString(), bean.getGender().toString(), bean.getAge().toString());
        }, Function.identity()));
        Set<String> keys = collect.keySet();
        System.out.println(keys);
    }

    // 创建一个包含 10 万条数据的示例原始 List
    private static List<Object> createOriginalList() {
        List<Object> originalList = new ArrayList<>();
        for (int i = 1; i <= 10008; i++) {
            originalList.add(i);
        }
        return originalList;
    }

    @Test
    public void testCollUtilSplitList() {
        List<Object> originalList = createOriginalList(); // 你的原始 List
        originalList.forEach(System.out::println);

        // 分组
        List<List<Object>> lists = CollUtil.split(originalList, 100);
        lists.forEach(System.out::println);
    }

    /**
     * 测试 List.stream().sorted()倒序
     *
     * @author Kang Yong
     * @date 2023/11/24
     */
    @Test
    public void testListSorted() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", new BigDecimal(30)));
        personList.add(new Person(2, 1, 19, "储小姣", new BigDecimal(20)));
        personList.add(new Person(5, 0, 19, "钱梦婷", new BigDecimal(70.89)));
        personList.add(new Person(4, 1, 18, "徐慧文", new BigDecimal(66.32)));
        personList.add(new Person(3, 0, 20, "张丹妮", new BigDecimal(22.10)));
        personList.add(new Person(6, 0, 20, "陆之昂", new BigDecimal(99.67)));

        personList.forEach(System.out::println);

        System.out.println("==================");

        List<Person> list = personList.stream()
                .sorted(Comparator.comparing(Person::getMoney).reversed())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * Map借助ArrayList排序
     *
     * @author Kang Yong
     * @date 2023/12/11
     */
    @Test
    public void testListSort() {
        HashMap<Long, String> map = new HashMap<>();
        map.put(1L, "one");
        map.put(4L, "four");
        map.put(2L, "two");
        map.put(3L, "three");

        List<Long> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for (Long key : sortedKeys) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }

    @Test
    public void testListSortAndConvert() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 18, "王丽丽", new BigDecimal(30)));
        personList.add(new Person(2, 1, 19, "储小姣", new BigDecimal(20)));
        personList.add(new Person(5, 0, 19, "钱梦婷", new BigDecimal(70.89)));
        personList.add(new Person(4, 1, 18, "徐慧文", new BigDecimal(66.32)));
        personList.add(new Person(3, 0, 20, "张丹妮", new BigDecimal(22.10)));
        personList.add(new Person(6, 0, 20, "陆之昂", new BigDecimal(99.67)));

        personList.forEach(System.out::println);

        System.out.println("==================");

        List<String> list = personList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * 测试List.add()
     *
     * @author Kang Yong
     * @date 2024/1/9
     */
    @Test
    public void testListAddNull() {
        List<Object> options = new ArrayList<>();
        options.add(null);
        List<Long> idList = this.getStaticLongList();
        if (!CollectionUtils.isEmpty(idList)) {
            options.addAll(idList);
        }

        for (Object o : options) {
            System.out.println("o = " + o);
        }

    }

    private List<Long> getStaticLongList() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        return list;
    }

    @Test
    public void testEmpty() {
        List<Person> pList = Collections.emptyList();

        Map<Integer, Person> personMap = pList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("personMap.size() = " + personMap.size());
    }

    /**
     * 测试list转map
     *
     * @author Kang Yong
     * @date 2024/2/1
     */
    @Test
    public void testDuplicateKey() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, 0, 18, "王丽丽", new BigDecimal(30)));
        personList.add(new Person(2, 1, 19, "储小姣", new BigDecimal(20)));
        personList.add(new Person(5, 0, 19, "钱梦婷", new BigDecimal(70.89)));
        personList.add(new Person(4, 1, 18, "徐慧文", new BigDecimal(66.32)));
        personList.add(new Person(3, 0, 20, "张丹妮", new BigDecimal(22.10)));
        personList.add(new Person(3, 0, 20, "刘亦菲", new BigDecimal(22.10)));
        personList.add(new Person(6, 0, 20, "陆之昂", new BigDecimal(99.67)));

        Map<Integer, UserDTO> dtoMap = personList.stream().distinct().collect(Collectors.toMap(Person::getId, item -> {
            return new UserDTO(new Long(item.getId()), item.getName());
        }));

        for (Map.Entry<Integer, UserDTO> entry : dtoMap.entrySet()) {
            System.out.println((entry.getKey() + ":" + entry.getValue()));
        }

    }

    @Test
    public void testOption() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, 0, 18, "王丽丽", new BigDecimal(30)));
        personList.add(new Person(2, 1, 19, "储小姣", new BigDecimal(20)));
        personList.add(new Person(5, 0, 19, "钱梦婷", new BigDecimal(70.89)));
        personList.add(new Person(4, 1, 18, "徐慧文", new BigDecimal(66.32)));
        personList.add(new Person(3, 0, 20, "张丹妮", new BigDecimal(22.10)));
        personList.add(new Person(3, 0, 20, "刘亦菲", new BigDecimal(22.10)));
        personList.add(new Person(6, 0, 20, "陆之昂", new BigDecimal(99.67)));

        // 找出age岁的第一个，获取名字
        int age = 17;
//        String name = personList.stream()
//                .filter(i -> i.getAge() == age)
//                .findFirst()
//                .get() // 这种写法会报错：java.util.NoSuchElementException: No value present
//                .getName();

        String name = personList.stream()
                .filter(i -> i.getAge() == age)
                .findFirst()
                .orElse(new Person())
                .getName();
        System.out.println("name = " + name);
    }

    /**
     * String 转为金额求和
     *
     * @author Kang Yong
     * @date 2024/6/4
     */
    @Test
    public void testStreamSum() {
        List<String> list = new ArrayList<>();
        list.add("10.11");
        list.add("11.11");
        list.add("12.11");
        list.add("18.00");

        BigDecimal total = list.stream().map(BigDecimal::new).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("total = " + total);
    }

    /**
     * 使用list stream功能求和
     *
     * @author Kang Yong
     * @date 2024/6/4
     */
    @Test
    public void testSumAge() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 1, "王丽丽"));
        personList.add(new Person(2, 1, 2, "储小姣"));
        personList.add(new Person(5, 0, 3, "钱梦婷"));
        personList.add(new Person(4, 1, 4, "徐慧文"));
        personList.add(new Person(3, 0, null, "张丹妮"));
        personList.add(new Person(6, 0, 6, "陆之昂"));

        int sum = personList.stream().filter(i -> Objects.nonNull(i.getAge())).mapToInt(Person::getAge).sum();
        System.out.println("sum = " + sum);
    }

    @Test
    public void testGetMinDate() {
        List<String> dataList = new ArrayList<>();
        dataList.add("2024-05-21");
        dataList.add("2024-04-21");
        dataList.add("2023-05-21");

        List<Date> collect = dataList.stream().map(i -> {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(i);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        Date min = Collections.min(collect);
        System.out.println("min = " + min);

        Date max = Collections.max(collect);
        System.out.println("max = " + max);

    }

    @Test
    public void testEmptyMap() {
        Map<Long, Integer> map = Collections.emptyMap();

        Integer i = map.getOrDefault(1L, 0);
        System.out.println("i = " + i);
    }

    @Test
    public void testSplit() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1,2,3");
        dataList.add("4,5,6");
        dataList.add("7,8,9");
        dataList.add("10,1,2");
        dataList.add("1,2,3");
        dataList.add("5,6,3");
        String userIdStr = dataList.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(","));
        System.out.println("userIdStr = " + userIdStr);

        List<Long> list = Arrays.stream(userIdStr.split(",")).map(Long::parseLong).distinct().collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testGetMaxIdEntity() {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person(1, 0, 1, "王丽丽"));
        personList.add(new Person(2, 1, 2, "储小姣"));
        personList.add(new Person(4, 1, 4, "徐慧文"));
        personList.add(new Person(5, 0, 3, "钱梦婷"));
        personList.add(new Person(3, 0, null, "张丹妮"));
        personList.add(new Person(6, 0, 6, "陆之昂"));

        Map<Integer, List<Person>> personMap = personList.stream().collect(Collectors.groupingBy(Person::getGender));
        // 获取每组ID最大的
        for (Map.Entry<Integer, List<Person>> entry : personMap.entrySet()) {
            List<Person> tempList = entry.getValue();
            Person maxIdPerson = Collections.max(tempList, Comparator.comparingInt(Person::getId));
            System.out.println("maxIdPerson = " + maxIdPerson);
        }

    }


}
