package top.kangyong.study01.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式：命令调用类
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/13
 * @since 1.0.0
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrder() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
