package top.kangyong.study01.design.pattern.builder;

/**
 * 鸡肉汉堡 用纸盒打包
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 27.5f;
    }
}
