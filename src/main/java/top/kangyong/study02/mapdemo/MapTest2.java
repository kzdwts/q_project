package top.kangyong.study02.mapdemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * map 原理
 *
 * @author Kang Yong
 * @date 2023/3/1
 * @since 1.0.0
 */
public class MapTest2 {

    /**
     * 功能: 测试HashMap设置初始大小和负载因子
     *
     * @author Kang Yong
     * @date 2023/3/1
     */
    @Test
    public void testMapSetLoadFactor() {
        // 创建HashMap对象，设置初始大小和负载因子(默认初始大小16，负载因子0.75f)
        Map<String, Integer> map = new HashMap<>(16, 0.75f);
        map.put("English", 138);
        map.put("Math", 146);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 最大的容积
        int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println("MAXIMUM_CAPACITY = " + MAXIMUM_CAPACITY);
    }

    /**
     * 测试HashTable
     *
     * @author Kang Yong
     * @date 2023/3/5
     */
    @Test
    public void testHashTable() {
        // HashTable
        Hashtable hashtable = new Hashtable();
        hashtable.put("name", "刘婷");
//        hashtable.put(null, null);
//        hashtable.put("age", null);
//        hashtable.put(null, 180);
        hashtable.put("", "yellow");
        hashtable.put("", "orange");
        for (Object o : hashtable.entrySet()) {
            System.out.println("o : " + o);
        }

        System.out.println("=============华丽的分割线=============");

        HashMap hashMap = new HashMap();
        hashMap.put("name", "康永");
        hashMap.put(null, null);
        hashMap.put("age", null);
        hashMap.put(null, 180);
        hashMap.put("", "yellow");
        hashMap.put("", "orange");
        for (Object o : hashMap.entrySet()) {
            System.out.println("o : " + o);
        }

    }

    /**
     * 测试key为null
     *
     * @author Kang Yong
     * @date 2023/11/2
     */
    @Test
    public void testKeyIsNull() {

        Map<String, Object> map = new HashMap<>();
        map.put(null, "王丽丽");
        map.put("zhangxingning", "张兴宁");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("k:" + entry.getKey() + "v:" + entry.getValue());
        }

        Object v = map.getOrDefault(null, "未知");
        System.out.println("v = " + v);

    }

}
