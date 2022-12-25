package top.kangyong.study02.design.pattern.behaviormode.command;

import java.util.Map;
import java.util.Set;

/**
 * 订单命令类
 * <p>
 * 命令模式
 *
 * @author Kang Yong
 * @date 2022/12/25
 * @since 1.0.0
 */
public class OrderCommand implements Command {

    // 持有接收者对象
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Map<String, Integer> foodDir = order.getFoodDir();
        Set<String> keys = foodDir.keySet();
        for (String foodName : keys) {
            receiver.makeFood(foodName, foodDir.get(foodName));
        }

        System.out.println(order.getDiningTable() + "桌的饭准备完了！！！");
    }
}
