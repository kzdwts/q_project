package top.kangyong.study01.lambda;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 汽车类
 * @author: kangyong
 * @date: 2020/9/16 18:49
 * @version: v1.0
 */
@Data
public class Cart {

    private Integer id;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 重量
     */
    private Float weight;

    /**
     * 颜色
     */
    private String color;

    public Cart(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Cart(Integer id, String brand, Float weight, String color) {
        this.id = id;
        this.brand = brand;
        this.weight = weight;
        this.color = color;
    }
}
