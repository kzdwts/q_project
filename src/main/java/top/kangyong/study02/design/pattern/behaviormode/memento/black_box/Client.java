package top.kangyong.study02.design.pattern.behaviormode.memento.black_box;


/**
 * test
 * <p>
 * 行为型模式-备忘录模式（黑盒）
 * <p>
 * 备忘录角色对发起人对象提供一个宽接口，而为其他对象提供一个窄接口。
 * 在java语言中，实现双重接口的方法就是将备忘录类设计出发起人类的内部成员类
 * <p>
 * 优点：
 * 提供了一种可以恢复状态的机制。当用户需要能够比较方便的将数据恢复到某个历史的状态
 * 实现了内部状态的封装，除了创建它的发起人之外，其他对象都不能够访问这些状态信息。（黑箱）
 * 简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则
 * <p>
 * 缺点：
 * 资源消耗大。如果要保存的内部状态信息过多或者特别繁杂，将会占用比较大的内存资源。
 * <p>
 * 使用场景：
 * 需要保存与恢复数据的场景，如玩游戏时的中检结果的存档功能。
 * 需要提供一个可回滚操作的场景，如word、记事本、idea等软件在编辑时按Ctrl+z组合键，还有数据库中事务操作
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
