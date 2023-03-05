package top.kangyong.study02.mapdemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 测试
 *
 * @author Kang Yong
 * @date 2023/3/6
 * @since 1.0.0
 */
public class LinkedHashMapTest {

    @Test
    public void LinkedHashMapCompareHashMapSortTest() {
        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        hashMap.put("d", 4);
        hashMap.put("e", 4);
        hashMap.put("apple", 5);
        hashMap.put("eason", 5);
        hashMap.put("beautiful", 5);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + "\tvalue: " + entry.getValue());
        }

        System.out.println("==============华丽的分割线===========");
        // LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", 1);
        linkedHashMap.put("b", 2);
        linkedHashMap.put("c", 3);
        linkedHashMap.put("d", 4);
        linkedHashMap.put("e", 4);
        linkedHashMap.put("apple", 5);
        linkedHashMap.put("eason", 5);
        linkedHashMap.put("beautiful", 5);

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + "\tvalue: " + entry.getValue());
        }

    }

}
