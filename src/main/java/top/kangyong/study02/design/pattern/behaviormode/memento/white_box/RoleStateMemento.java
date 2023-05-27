package top.kangyong.study02.design.pattern.behaviormode.memento.white_box;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 备忘录角色类（存储历史状态）
 * <p>
 * 行为型模式-备忘录模式（白盒）
 *
 * @author Kang Yong
 * @date 2023/5/27
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleStateMemento {

    /**
     * 生命力
     */
    private int vit;
    /**
     * 攻击力
     */
    private int atk;
    /**
     * 防御力
     */
    private int def;

}
