package top.kangyong.study02.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数字组合
 *
 * @author Kang Yong
 * @date 2023/10/27
 * @since 1.0.0
 */
public class NumCombination {

    public static void main(String[] args) {
        int currentMonth = 1;  // 10月
        List<List<Integer>> combinations = generateMonthCombinations(currentMonth);

        // 打印生成的组合
        for (List<Integer> c : combinations) {
            String cc = c.stream().map(integer -> integer.toString()).collect(Collectors.joining(","));
            System.out.println(cc);
        }

        System.out.println("combinations.size() = " + combinations.size());
    }

    public static List<List<Integer>> generateMonthCombinations(int currentMonth) {
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 1; i <= currentMonth; i++) {
            List<Integer> combination = new ArrayList<>();
            for (int j = i; j <= currentMonth; j++) {
                combination.add(j);
                combinations.add(new ArrayList<>(combination));
            }
        }

        return combinations;
    }

}
