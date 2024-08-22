package top.kangyong.study02.demo.dke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 条件
 *
 * @author Kang Yong
 * @date 2024/8/21
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCondition implements Serializable {

    /**
     * 字段编码
     */
    private String fieldCode;
    /**
     * 字段名称
     */
    private String fieldName;
    /**
     * 字段数据源（配置SQL）
     */
    private String fieldSource;
    /**
     * 字段可选值集合
     */
    private List<String> fieldValueList;

}
