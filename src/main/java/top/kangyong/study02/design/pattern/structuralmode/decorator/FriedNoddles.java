package top.kangyong.study02.design.pattern.structuralmode.decorator;

/**
 * 炒面（具体构件角色）
 * <p>
 * 装饰器模式
 *
 * @author Kang Yong
 * @date 2022/11/6
 * @since 1.0.0
 */
public class FriedNoddles extends FastFood {

    public FriedNoddles() {
        super(12, "炒面条");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
