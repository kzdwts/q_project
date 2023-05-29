package top.kangyong.study02.design.pattern.behaviormode.memento.black_box;


/**
 * test
 * <p>
 * 行为型模式-备忘录模式（黑盒）
 * <p>
 * 备忘录角色对发起人对象提供一个宽接口，而为其他对象提供一个窄接口。
 * 在java语言中，实现双重接口的方法就是将备忘录类设计出发起人类的内部成员类
 *
 * @author Kang Yong
 * @date 2023/5/29
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
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("==============大战boss后===============");

        // 损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("==============恢复之前的状态===============");

        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();

    }

}
