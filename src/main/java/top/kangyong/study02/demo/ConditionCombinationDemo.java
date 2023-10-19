package top.kangyong.study02.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有8个查询条件，都是下拉框选择项，有字符串（String）及数字（Integer）类型。
 * 比如：条件1（全部、选项1、选项2、选项3），
 *      条件2（全部、选项1、选项2、选项3），
 *      条件3（全部、138，246），以此类推。
 * 我想要得到这8个条件组成的笛卡尔积，用Java代码该怎么写
 *
 * @author Kang Yong
 * @date 2023/10/19
 * @since 2.0.0
 */
public class ConditionCombinationDemo {
    public static void main(String[] args) {
        // 8个查询条件的选项
        Object[] areaOptions = {"全部", "A", "B"};
        Object[] cityOptions = {"全部", "A1", "A2", "A3"};
        Object[] projectOptions = {"全部", "X", "Y"};
        Object[] businessOptions = {"不选", 138, 246};
        Object[] option5 = {"不选", 100, 200};
        Object[] option6 = {"不选", "A", "B"};
        Object[] option7 = {"不选", 10, 20};
        Object[] option8 = {"不选", "X", "Y"};

        List<Object[]> conditions = new ArrayList<>();
        conditions.add(areaOptions);
        conditions.add(cityOptions);
        conditions.add(projectOptions);
        conditions.add(businessOptions);
        conditions.add(option5);
        conditions.add(option6);
        conditions.add(option7);
        conditions.add(option8);

        List<List<Object>> result = new ArrayList<>();
        cartesianProduct(result, conditions, new ArrayList<>(), 0);

        // 打印所有可能的组合
        for (List<Object> combination : result) {
            System.out.println(combination);
        }
    }

    public static void cartesianProduct(List<List<Object>> result, List<Object[]> conditions, List<Object> current, int index) {
        if (index == conditions.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        Object[] options = conditions.get(index);
        for (Object option : options) {
            current.add(option);
            cartesianProduct(result, conditions, current, index + 1);
            current.remove(current.size() - 1);
        }
    }

}
