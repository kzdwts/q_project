package top.kangyong.study01.design.pattern.builder;

/**
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/23
 * @since 1.0.0
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
