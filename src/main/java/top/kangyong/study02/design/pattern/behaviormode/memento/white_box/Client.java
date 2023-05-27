package top.kangyong.study02.design.pattern.behaviormode.memento.white_box;

/**
 * test
 * <p>
 * 行为型模式-备忘录模式（白盒）
 *
 * @author Kang Yong
 * @date 2023/5/27
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("==============大战boss前===============");

        // 创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        // 将该游戏角色内部状态进行备份
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        System.out.println("==============大战boss后===============");

        // 损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("==============恢复之前的状态===============");

        gameRole.recoverState(roleStateCaretaker.getRoleStateMemento());
        gameRole.stateDisplay();

    }
}
