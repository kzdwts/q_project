package top.kangyong.study02.design.pattern.structuralmode.decorator;

/**
 * 具体的装饰者角色：培根类
 * <p>
 * 装饰者模式
 *
 * @author Kang Yong
 * @date 2022/11/7
 * @since 1.0.0
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    @Override
    public float cost() {
        // 计算价格： 鸡蛋价格 + 主食价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
