package top.kangyong.study02.mapdemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
}
