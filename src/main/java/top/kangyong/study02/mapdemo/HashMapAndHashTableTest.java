package top.kangyong.study02.mapdemo;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap 和 HashTable 两者比较
 * <p>
 * 1、线程安全性
 * 2、null值
 * 3、效率
 * 4、迭代器
 * 5、存储顺序
 *
 * @author Kang Yong
 * @date 2023/3/5
 * @since 1.0.0
 */
public class HashMapAndHashTableTest implements Runnable {

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static Hashtable<Integer, Integer> hashTable = new Hashtable();

    private static int MAX_COUNT = 100000;

    @Override
    public void run() {
        for (int i = 0; i < MAX_COUNT; i++) {
//            如果不加sychronized就会出现线程安全问题
//            synchronized (HashMapAndHashTableTest.class) {
                hashMap.put(i, i);
//            }

            hashTable.put(i, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HashMapAndHashTableTest test = new HashMapAndHashTableTest();

        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashTable.size() = " + hashTable.size());
    }
}
