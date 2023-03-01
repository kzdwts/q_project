package top.kangyong.study02.mapdemo;

import org.junit.Test;

import java.util.HashMap;
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

}
