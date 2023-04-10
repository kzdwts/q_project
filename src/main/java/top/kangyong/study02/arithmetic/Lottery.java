package top.kangyong.study02.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 福利彩票生成器
 *
 * @author Kang Yong
 * @date 2023/4/10
 * @since 1.0.0
 */
public class Lottery {

    private static final int MAX_NUM = 35;
    private static final int MAX_SPECIAL_NUM = 12;
    private static final int NUM_COUNT = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // 随机生成 6 个不重复的数字
        while (numbers.size() < NUM_COUNT) {
            int num = random.nextInt(MAX_NUM) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        // 对生成的数字进行排序
        Collections.sort(numbers);

        // 随机生成一个特别号码
        int specialNum = random.nextInt(MAX_SPECIAL_NUM) + 1;

        // 添加到列表
        numbers.add(specialNum);
        return numbers;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            List<Integer> numbers = generateNumbers();
            for (Integer number : numbers) {
                System.out.print(String.format("%02d, ", number));
            }
            System.out.println();
        }
    }
}
