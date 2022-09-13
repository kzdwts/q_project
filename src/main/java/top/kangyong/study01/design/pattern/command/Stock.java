package top.kangyong.study01.design.pattern.command;

/**
 * 命令模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/9/13
 * @since 1.0.0
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock[ Name: " + name + ", Quantity: " + quantity + "] bought");
    }

    public void sell() {
        System.out.println("Stock[ Name: " + name + ", Quantity: " + quantity + "] sold");
    }
}
