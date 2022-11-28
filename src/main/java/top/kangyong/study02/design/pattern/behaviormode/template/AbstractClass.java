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

    public void pourOil() {
        System.out.println("倒油");
    }

    public void heatOil() {
        System.out.println("热油");
    }

    public abstract void pourVegetable();

    public abstract void pourSauce();

    public void fry() {
        System.out.println("炒啊炒啊炒到熟啊");
    }
}
