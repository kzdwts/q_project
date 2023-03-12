package top.kangyong.study02.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 学习
 *
 * @author Kang Yong
 * @date 2022/1/7
 * @see 'https://leetcode-cn.com/problems'
 * @since 1.0.0
 */
public class LeetCodeStudy01 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
     * 并返回它们的数组下标。
     */
    @Test
    public void twoSum1() {
        int[] nums = {11, 7, 11, 2};
        int target = 9;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("坐标为：[" + i + ", " + j + "]");
                    return;
                }
            }
        }

    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
     * 并返回它们的数组下标。
     */
    @Test
    public void twoSum2() {
        int[] nums = {11, 7, 11, 2};
        int target = 9;

        // 循环一次
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 索引，值，目标
            if (map.containsKey(nums[i])) {
                System.out.println("坐标为：[" + map.get(nums[i]) + ", " + i + "]");
                return;
            }
            // k → v ，值 → 索引
            map.put(target - nums[i], i);
        }
    }

    /**
     * q: 给定一个数组，给定一个数字。返回数组中可以相加得到指定数字的两个索引
     * two sum from <link>https://mp.weixin.qq.com/s/5mwkgJB7GyLdKDgzijyvXw</link>
     *
     * @author Kang Yong
     * @date 2023/3/13
     */
    @Test
    public void twoSum3Test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = this.twoSum3(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


}
