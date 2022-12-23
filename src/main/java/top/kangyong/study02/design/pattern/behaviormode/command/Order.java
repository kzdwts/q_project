package top.kangyong.study02.design.pattern.behaviormode.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类
 * <p>
 * 命令模式
 *
 * @author Kang Yong
 * @date 2022/12/23
 * @since 1.0.0
 */
public class Order {

    // 餐桌号码
    private int diningTable;

    // 所下的餐品及份数
    private Map<String, Integer> foodDir = new HashMap<>();
}
