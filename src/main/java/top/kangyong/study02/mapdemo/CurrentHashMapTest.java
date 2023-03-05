package top.kangyong.study02.mapdemo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CurrentHashMap 线程安全问题
 *
 * @author Kang Yong
 * @date 2023/3/5
 * @since 1.0.0
 */
public class CurrentHashMapTest {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        new Thread(() -> {
            map.put("e", 5);
            System.out.println(map.get("a"));
        }).start();

        new Thread(() -> {
            map.put("f", 6);
            System.out.println(map.get("b"));
        }).start();

    }

}
