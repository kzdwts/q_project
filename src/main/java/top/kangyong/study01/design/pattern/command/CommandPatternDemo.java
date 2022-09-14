package top.kangyong.study01.design.pattern.command;

/**
 * 命令模式
 * <p>
 * 结构型模式
 *
 * @author Kang Yong
 * @date 2022/9/14
 * @since 1.0.0
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrder();
    }

}
