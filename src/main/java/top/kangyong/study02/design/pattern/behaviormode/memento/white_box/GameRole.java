package top.kangyong.study02.design.pattern.behaviormode.memento.white_box;

import lombok.Data;

/**
 * 游戏角色类（属于发起人角色）
 * <p>
 * 行为型模式-备忘录模式（白盒）
 *
 * @author Kang Yong
 * @date 2023/5/24
 * @since 1.0.0
 */
@Data
public class GameRole {

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

    /**
     * 初始化内部状态
     */
    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    /**
     * 战斗
     */
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

}
