package top.kangyong.study02.demo.dke;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 组笛卡尔积测试
 *
 * @author Kang Yong
 * @date 2024/8/21
 * @since 1.0.0
 */
public class DkeDemo {

    public static void main(String[] args) {
        // 创建示例 List<ReportCondition>
        List<ReportCondition> conditions = new ArrayList<>();
        conditions.add(new ReportCondition("color", "颜色", null, CollUtil.toList("red", "blue")));
        conditions.add(new ReportCondition("size", "尺寸", null, CollUtil.toList("small", "medium", "large")));
        conditions.add(new ReportCondition("company", "公司", null, CollUtil.toList("北京优码", "合肥硕展")));

        // 计算笛卡尔积
        List<Map<String, String>> result = cartesianProduct(conditions);

        // 输出结果
        System.out.println("JSON.toJSONString(result) = " + JSON.toJSONString(result));
        for (Map<String, String> combination : result) {
            System.out.println(combinationToString(combination));
        }
    }

    public static List<Map<String, String>> cartesianProduct(List<ReportCondition> conditions) {
        // 获取每个 Condition 的 fieldValueList
        List<List<String>> valueLists = conditions.stream()
                .map(ReportCondition::getFieldValueList)
                .collect(Collectors.toList());

        // 获取列表数量
        int numLists = valueLists.size();

        // 初始化结果列表
        List<Map<String, String>> result = new ArrayList<>();

        // 为每个列表初始化一个索引
        int[] indices = new int[numLists];

        // 主循环
        while (true) {
            // 重置当前组合
            Map<String, String> current = new HashMap<>();

            // 构建当前组合
            for (int i = 0; i < numLists; i++) {
                ReportCondition condition = conditions.get(i);
                String fieldValue = valueLists.get(i).get(indices[i]);
                current.put(condition.getFieldCode(), fieldValue);
            }

            // 添加当前组合到结果列表
            result.add(new HashMap<>(current));

            // 更新索引
            int i = numLists - 1;
            while (i >= 0) {
                // 如果当前索引还没有到达列表末尾，则增加索引
                if (indices[i] < valueLists.get(i).size() - 1) {
                    indices[i]++;
                    break;
                } else {
                    // 如果当前索引已经到达列表末尾，则重置索引并向左移动
                    indices[i] = 0;
                    i--;
                }
            }

            // 如果所有索引都回到初始状态，则结束循环
            if (i < 0) {
                break;
            }
        }

        return result;
    }

    private static String combinationToString(Map<String, String> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

}

