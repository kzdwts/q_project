package top.kangyong.study02.setcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set 集合
 *
 * @author Kang Yong
 * @date 2023/2/24
 * @since 1.0.0
 */
public class SetTest {

    /**
     * 测试Set集合加入相同数据
     * <p>
     * 最后只有一个
     *
     * @author Kang Yong
     * @date 2023/2/24
     */
    @Test
    public void addTest() {
        Set<Integer> busCodeSet = new HashSet<>();
        busCodeSet.add(1001);
        busCodeSet.add(1002);
        busCodeSet.add(1001);

        busCodeSet.forEach(System.out::println);
    }

    /**
     * 测试Set 集合add List集合
     *
     * @author Kang Yong
     * @date 2023/2/24
     */
    @Test
    public void setAddAllList() {
        Set<Integer> busCodeSet = new HashSet<>();
        busCodeSet.add(1001);
        busCodeSet.add(1002);

        List<Integer> numList = new ArrayList<>();
        numList.add(1001);
        numList.add(1002);
        numList.add(1003);
        numList.add(1004);

        busCodeSet.addAll(numList);
        busCodeSet.forEach(System.out::println);
    }
}
