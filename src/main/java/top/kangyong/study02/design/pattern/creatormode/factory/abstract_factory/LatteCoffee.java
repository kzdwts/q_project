package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 抽象工厂模式 拿铁咖啡类
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/21
 * @since 1.0.0
 */
public class LatteCoffee extends Coffee {

    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}
