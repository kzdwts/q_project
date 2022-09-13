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
public class SellStock implements Order {

    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
