package top.kangyong.study02.design.pattern.creatormode.factory.factory_method;

/**
 * 工厂方法模式
 *
 * @author Kang Yong
 * @date 2022/9/19
 * @since 1.0.0
 */
public abstract class Coffee {

    public abstract String getName();

    /**
     * 加糖
     *
     * @author Kang Yong
     * @date 2022/9/19
     */
    public void addSugar() {
        System.out.println("加糖");
    }

    /**
     * 加奶
     *
     * @author Kang Yong
     * @date 2022/9/19
     */
    public void addMilk() {
        System.out.println("加奶");
    }
}
