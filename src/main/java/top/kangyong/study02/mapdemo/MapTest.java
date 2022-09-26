package top.kangyong.study02.mapdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * map遍历
 *
 * @author Kang Yong
 * @date 2022/1/13
 * @since 1.0.0
 */
public class MapTest {

    /**
     * 方法一：普通的foreach循环，使用keySet()方法，遍历key
     */
    @Test
    public void testForeach() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "美好的周一");
        map.put(2, "美好的周二");
        map.put(3, "美好的周三");

        for (Integer key : map.keySet()) {
            System.out.println("key:" + key + " " + "Value:" + map.get(key));
        }
    }

    /**
     * 方法二：把所有的键值对装入迭代器中，然后遍历迭代器
     */
    @Test
    public void testDemo2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "美好的周一");
        map.put(2, "美好的周二");
        map.put(3, "美好的周三");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + " " + "Value:" + entry.getValue());
        }
    }

    /**
     * 方法三：分别得到key和value
     */
    @Test
    public void testDemo3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "美好的周一");
        map.put(2, "美好的周二");
        map.put(3, "美好的周三");

        for (Integer key : map.keySet()) {
            System.out.println("key: " + key);
        }
        for (String value : map.values()) {
            System.out.println("value: " + value);
        }
    }

    /**
     * 方法四：entrySet()方法
     */
    @Test
    public void testDemo4() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "美好的周一");
        map.put(2, "美好的周二");
        map.put(3, "美好的周三");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key:" + entry.getKey() + " " + "Value:" + entry.getValue());
        }
    }

    /**
     * Map<Integer, String> 转Map<String, String>
     *
     * @author Kang Yong
     * @date 2022/9/22
     */
    @Test
    public void testConvertDemo01() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "王丽丽");
        map1.put("2", "钱梦婷");
        map1.put("3", "陆智航");

        String jsonString = JSON.toJSONString(map1);
        System.out.println(jsonString);

        Map<Integer, String> map2 = JSON.parseObject(jsonString, new TypeReference<Map<Integer, String>>() {
        });
        String jsonString2 = JSON.toJSONString(map2);
        System.out.println(jsonString2);
    }

    /**
     * Map<String, String> 转Map<Integer, String>
     *
     * @author Kang Yong
     * @date 2022/9/22
     */
    @Test
    public void testConvertDemo02() {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "王丽丽");
        map1.put(2, "钱梦婷");
        map1.put(3, "陆智航");

        Map<String, String> map2 = map1.entrySet().stream().collect(Collectors.toMap((en) -> String.valueOf(en.getKey()), Map.Entry::getValue));
        System.out.println(JSON.toJSONString(map2));
    }

    /**
     * Map<Integer, String> 转List<Person>
     *
     * @author Kang Yong
     * @date 2022/9/23
     */
    @Test
    public void testMap2List() {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "王丽丽");
        map1.put(2, "钱梦婷");
        map1.put(3, "陆智航");

        List<Person> personList = map1.entrySet().stream().map(m -> (new Person(m.getKey(), m.getValue()))).collect(Collectors.toList());
        System.out.println(personList);
    }

    /**
     * Map get Null Key
     *
     * @author Kang Yong
     * @date 2022/9/23
     */
    @Test
    public void testMapGetNullKey() {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "王丽丽");
        map1.put(2, "钱梦婷");
        map1.put(3, "陆智航");

        String name = map1.getOrDefault(null, "ceshi");
        System.out.println(name);

        String wanglili = map1.getOrDefault(1, "wanglili");
        System.out.println(wanglili);


    }
}
