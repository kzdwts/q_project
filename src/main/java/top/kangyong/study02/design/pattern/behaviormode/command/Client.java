package top.kangyong.study02.design.pattern.behaviormode.command;

/**
 * test
 * <p>
 * 命令模式
 *
 * @author Kang Yong
 * @date 2022/12/25
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("蛋炒饭", 1);
        order1.setFood("小可乐", 1);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("尖椒肉丝盖饭", 1);
        order2.setFood("小雪碧", 1);

        // 创建厨师对象
        SeniorChef receiver = new SeniorChef();
        // 命令对象
        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        // 服务员对象
        Waitor invoke = new Waitor();
        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        invoke.orderUp();

    }

}
