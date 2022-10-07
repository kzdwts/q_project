package top.kangyong.study02.inherit;

import lombok.Data;
import lombok.ToString;

/**
 * 动物：狗狗
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
@Data
@ToString
public class Dog extends Animal {

    /**
     * 叫声
     */
    private String cry;

    /**
     * 技能
     */
    private String skill;
}
