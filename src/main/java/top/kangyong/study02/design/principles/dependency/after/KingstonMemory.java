package top.kangyong.study02.design.principles.dependency.after;

/**
 * 金士顿内存条
 * <p>
 * 依赖倒置原则
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public class KingstonMemory implements Memory {

    @Override
    public void save() {
        System.out.println("使用金士顿内存条");
    }
}
