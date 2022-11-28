package top.kangyong.study02.design.pattern.behaviormode.template;

/**
 * 炒菜心类
 * <p>
 * 模板方法模式
 *
 * @author Kang Yong
 * @date 2022/11/28
 * @since 1.0.0
 */
public class ConcreteClass_CaiXin extends AbstractClass {
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的调料是蒜蓉");
    }
}
