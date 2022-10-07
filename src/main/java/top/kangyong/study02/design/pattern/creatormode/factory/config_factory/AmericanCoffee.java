package top.kangyong.study02.design.pattern.creatormode.factory.config_factory;

/**
 * 美式咖啡
 * <p>
 * 模式扩展：配置文件+工厂模式
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class AmericanCoffee extends Coffee {

    @Override
    public String getName() {
        return "美式咖啡";
    }

}
