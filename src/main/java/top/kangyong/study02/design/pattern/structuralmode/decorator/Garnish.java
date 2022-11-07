package top.kangyong.study02.design.pattern.structuralmode.decorator;

/**
 * 装饰者类（抽象装饰者角色）
 * <p>
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/11/6
 * @since 1.0.0
 */
public abstract class Garnish extends FastFood {

    // 声明快餐类的对象
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
