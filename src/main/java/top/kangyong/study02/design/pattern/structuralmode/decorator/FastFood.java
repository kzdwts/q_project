package top.kangyong.study02.design.pattern.structuralmode.decorator;

/**
 * 快餐类（抽象构件(Component)角色）
 * <p>
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/11/6
 * @since 1.0.0
 */
public abstract class FastFood {

    /**
     *
     */
    private float price;
    /**
     * 描述
     */
    private String desc;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public FastFood() {
    }

    /**
     * 计算价格（子类实现，因为子类才知道具体的价格）
     *
     * @return {@link float}
     * @author Kang Yong
     * @date 2022/11/6
     */
    public abstract float cost();
}
