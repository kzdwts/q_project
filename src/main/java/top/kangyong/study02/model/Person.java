package top.kangyong.study02.model;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;
import lombok.ToString;

/**
 * 人 实体类
 *
 * @author Kang Yong
 * @date 2022/1/6
 * @since 1.0.0
 */
@Data
@ToString
@JSONType(orders = {"id", "name", "age", "gender", "weight"})
public class Person {


    /**
     * 主键id
     */
    private Integer id;

    /**
     * 性别：0女，1男，2未知
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体重（单位：kg，保留两位小数）
     */
    private Float weight;

    /**
     * 姓名
     */
    private String name;


}
