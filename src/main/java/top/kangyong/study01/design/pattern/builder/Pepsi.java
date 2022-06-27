package top.kangyong.study01.design.pattern.builder;

/**
 * 百事可乐，用冷饮瓶子包装
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi 百事可乐";
    }

    @Override
    public float price() {
        return 5.5f;
    }
}
