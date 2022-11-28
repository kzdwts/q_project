package top.kangyong.study02.design.pattern.behaviormode.template;

/**
 * 抽象类
 * <p>
 * 模板模式
 *
 * @author Kang Yong
 * @date 2022/11/28
 * @since 1.0.0
 */
public abstract class AbstractClass {

    /**
     * 模板方法（final不允许修改）
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public final void cookProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    /**
     * 第一步：倒油
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public void pourOil() {
        System.out.println("倒油");
    }

    /**
     * 第二步：热油 是一样的，所以直接实现
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public void heatOil() {
        System.out.println("热油");
    }

    /**
     * 第三步：倒蔬菜 是不一样的（一个下包菜，一个下菜心）
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public abstract void pourVegetable();

    /**
     * 第四步：倒调味料 不同的菜调味料是不一样的
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public abstract void pourSauce();

    /**
     * 第五步：翻炒 是一样的，所以直接实现
     *
     * @author Kang Yong
     * @date 2022/11/28
     */
    public void fry() {
        System.out.println("炒啊炒啊炒到熟啊");
    }

}
