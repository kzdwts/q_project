package top.kangyong.study01.design.pattern.builder;

/**
 * 蔬菜汉堡 用纸盒打包
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        // 名称叫蔬菜汉堡
        return "Veg Burger";
    }

    @Override
    public float price() {
        // 价格25元
        return 25.0f;
    }
}
