package top.kangyong.study02.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

/**
 * 汽车
 *
 * @author Kang Yong
 * @date 2022/1/6
 * @since 1.0.0
 */
@Data
@ToString
public class Car {

    /**
     * 品牌
     */
    @JSONField(ordinal = 1)
    private String brand;

    /**
     * 颜色
     */
    @JSONField(ordinal = 2)
    private String color;

    /**
     * 汽车型号
     */
    @JSONField(ordinal = 3)
    private String type;

    /**
     * 重量(单位：kg)
     */
    @JSONField(ordinal = 4)
    private Float weight;

    /**
     * 排量
     */
    @JSONField(ordinal = 5)
    private String pl;

    /**
     * 驱动方式
     */
    @JSONField(ordinal = 6)
    private String driveMode;
}
