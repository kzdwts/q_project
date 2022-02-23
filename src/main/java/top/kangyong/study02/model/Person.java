package top.kangyong.study02.model;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
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

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 无参构造
     */
    public Person() {
    }

    /**
     * @param id     主键
     * @param gender 性别：0女，1男，2未知
     * @param age    年龄
     * @param name   姓名
     */
    public Person(Integer id, Integer gender, Integer age, String name) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.name = name;
    }

    /**
     * @param id          主键
     * @param gender      性别：0女，1男，2未知
     * @param age         年龄
     * @param name        姓名
     * @param nationality 国籍
     * @return {@link null}
     * @author Kang Yong
     * @date 2022/2/23
     */
    public Person(Integer id, Integer gender, Integer age, String name, String nationality) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.nationality = nationality;
    }
}
