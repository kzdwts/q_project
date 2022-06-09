package top.kangyong.study01.design.pattern.abstract_factory.color;

/**
 * 蓝色
 * <p>
 * 抽象工厂模式
 *
 * @author Kang Yong
 * @date 2022/6/9
 * @since 1.0.0
 */
public class Blue implements Color {
    /**
     * 喷色
     *
     * @author Kang Yong
     * @date 2022/6/9
     */
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
