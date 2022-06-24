package top.kangyong.study01.design.pattern.builder;

/**
 * 冷饮
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
