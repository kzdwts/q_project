package top.kangyong.study01.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * 计算总金额
     *
     * @return {@link float}
     * @author Kang Yong
     * @date 2022/6/24
     */
    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    /**
     * 展示商品
     *
     * @author Kang Yong
     * @date 2022/6/24
     */
    public void showItems() {
        for (Item item : items) {
            System.out.print("Item: " + item.name());
            System.out.print(", Packing: " + item.packing().pack());
            System.out.println(", Price: " + item.price());
        }
    }
}
