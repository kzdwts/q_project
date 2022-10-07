package top.kangyong.study02.inherit;

import lombok.Data;
import lombok.ToString;

/**
 * 动物：猫科
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
@Data
@ToString
public class Cat extends Animal {

    private String color;

    private String skill;
}
