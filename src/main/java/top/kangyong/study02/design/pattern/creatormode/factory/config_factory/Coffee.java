package top.kangyong.study02.design.pattern.creatormode.factory.config_factory;

/**
 * 咖啡
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public abstract class Coffee {

    public abstract String getName();

    /**
     * 加糖
     *
     * @author Kang Yong
     * @date 2022/10/7
     */
    public void addSugar() {
        System.out.println("加糖");
    }

    /**
     * 加奶
     *
     * @author Kang Yong
     * @date 2022/10/7
     */
    public void addMilk() {
        System.out.println("加奶");
    }

}
