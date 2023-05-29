package top.kangyong.study02.design.pattern.behaviormode.memento.black_box;

import lombok.Getter;
import lombok.Setter;

/**
 * 游戏角色类（属于发起人角色）
 * <p>
 * 行为型模式-备忘录模式（黑盒）
 *
 * @author Kang Yong
 * @date 2023/5/24
 * @since 1.0.0
 */
public class GameRole {

    /**
     * 生命力
     */
    @Getter
    @Setter
    private int vit;
    /**
     * 攻击力
     */
    @Getter
    @Setter
    private int atk;
    /**
     * 防御力
     */
    @Getter
    @Setter
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

    /**
     * 保存角色状态
     *
     * @return
     */
    public Memento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    /**
     * 恢复角色状态
     */
    public void recoverState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        // 将备忘录对象中存储的状态赋值给当前对象的成员
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    /**
     * 展示状态功能
     */
    public void stateDisplay() {
        System.out.println("角色生命力： " + vit);
        System.out.println("角色攻击力： " + atk);
        System.out.println("角色防御力： " + def);
    }


    private class RoleStateMemento implements Memento {
        /**
         * 生命力
         */
        @Getter
        @Setter
        private int vit;
        /**
         * 攻击力
         */
        @Getter
        @Setter
        private int atk;
        /**
         * 防御力
         */
        @Getter
        @Setter
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

        /**
         * 保存角色状态
         *
         * @return
         */
        public RoleStateMemento saveState() {
            return new RoleStateMemento(vit, atk, def);
        }

        /**
         * 恢复角色状态
         */
        public void recoverState(RoleStateMemento roleStateMemento) {
            // 将备忘录对象中存储的状态赋值给当前对象的成员
            this.vit = roleStateMemento.getVit();
            this.atk = roleStateMemento.getAtk();
            this.def = roleStateMemento.getDef();
        }

        /**
         * 展示状态功能
         */
        public void stateDisplay() {
            System.out.println("角色生命力： " + vit);
            System.out.println("角色攻击力： " + atk);
            System.out.println("角色防御力： " + def);
        }

        public RoleStateMemento() {
        }

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }
    }

}
