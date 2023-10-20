package top.kangyong.study02.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有8个查询条件，都是下拉框选择项，有字符串（String）及数字（Integer）类型。
 * 比如：条件1（0、选项1、选项2、选项3），
 * 条件2（0、选项1、选项2、选项3），
 * 条件3（0、138，246），以此类推。
 * 我想要得到这8个条件组成的笛卡尔积，用Java代码该怎么写
 *
 * @author Kang Yong
 * @date 2023/10/19
 * @since 2.0.0
 */
public class ConditionCombinationDemo {

    public static void main(String[] args) {
        List<ProjectOverviewConditionDTO> result = new ArrayList<>();
        generateCombinations(result, new ProjectOverviewConditionDTO(), 0);

        // 打印或使用生成的条件
        for (ProjectOverviewConditionDTO condition : result) {
            System.out.println(condition);
        }

        System.out.println("result.size() = " + result.size());
    }

    public static void generateCombinations(List<ProjectOverviewConditionDTO> result, ProjectOverviewConditionDTO currentCondition, int currentIndex) {
        if (currentIndex == 7) {
            result.add(currentCondition.clone()); // 克隆条件并将其添加到结果列表
            return;
        }

        // 为每个条件定义选项
        List<Object> options = new ArrayList<>();
        if (currentIndex == 0) {
            options.add("0");  // 不选
            options.add("A");
            options.add("B");
            // 添加其他区域选项
        } else if (currentIndex == 1) {
            // 根据选择的区域添加城市选项
            String selectedRegion = currentCondition.getRegion();
            if (selectedRegion == null || selectedRegion.equals("0")) {
                options.add("0");  // 不选
            } else if (selectedRegion.equals("A")) {
                options.add("0");  // 不选
                options.add("A1");
                options.add("A2");
                // 添加区域A下的其他城市选项
            }
            // 添加其他区域的城市选项
        } else if (currentIndex == 2) {
            options.add("0");  // 不选
            options.add("138");
            options.add("246");
        } else if (currentIndex == 3) {
            options.add(0);  // 不选
            options.add(111);
            options.add(222);
        } else if (currentIndex == 4) {
            // 添加年份选项，如：当前年份为2023，添加2022和2023
            int currentYear = 2023;
            options.add(currentYear - 1);
            options.add(currentYear);
        } else if (currentIndex == 5) {
            options.add(0);  // 不选
            options.add(101);
            options.add(102);
        } else if (currentIndex == 6) {
            options.add(1);  // 默认选择
            options.add(2);
        }

        // 递归生成每个选项的条件
        for (Object option : options) {
            if (currentIndex == 0) {
                currentCondition.setRegion((String) option);
            } else if (currentIndex == 1) {
                currentCondition.setCity((String) option);
            } else if (currentIndex == 2) {
                currentCondition.setBusiness((String) option);
            } else if (currentIndex == 3) {
                currentCondition.setDecorationType((Integer) option);
            } else if (currentIndex == 4) {
                currentCondition.setYear((Integer) option);
            } else if (currentIndex == 5) {
                currentCondition.setAssessment((Integer) option);
            } else if (currentIndex == 6) {
                currentCondition.setWeighted((Integer) option);
            }

            generateCombinations(result, currentCondition, currentIndex + 1);
        }
    }
}

@Data
class ProjectOverviewConditionDTO {
    private String region;
    private String city;
    private String business;
    private Integer decorationType;
    private Integer year;
    private Integer assessment;
    private Integer weighted;

    // Getter and setter methods for the fields
    // Clone method to create a copy of the object

    public ProjectOverviewConditionDTO clone() {
        ProjectOverviewConditionDTO clonedCondition = new ProjectOverviewConditionDTO();
        clonedCondition.setRegion(this.region);
        clonedCondition.setCity(this.city);
        clonedCondition.setBusiness(this.business);
        clonedCondition.setDecorationType(this.decorationType);
        clonedCondition.setYear(this.year);
        clonedCondition.setAssessment(this.assessment);
        clonedCondition.setWeighted(this.weighted);
        return clonedCondition;
    }


}