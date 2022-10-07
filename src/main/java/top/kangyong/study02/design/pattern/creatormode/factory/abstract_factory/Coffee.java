package top.kangyong.study02.design.pattern.creatormode.factory.abstract_factory;

/**
 * 抽象工厂模式 咖啡类
 * <p>
 * 创建型模式
 *
 * @author Kang Yong
 * @date 2022/8/21
 * @since 1.0.0
 */
public abstract class Coffee {

    /**
     * 获取名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/8/21
     */
    public abstract String getName();

    /**
     * 加糖
     *
     * @author Kang Yong
     * @date 2022/8/21
     */
    public void addSugar() {
        System.out.println("加糖");
    }

    /**
     * 加奶
     *
     * @author Kang Yong
     * @date 2022/8/21
     */
    public void addMilk() {
        System.out.println("加奶");
    }

}
