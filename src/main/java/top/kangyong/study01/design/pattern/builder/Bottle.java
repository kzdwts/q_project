package top.kangyong.study01.design.pattern.builder;

/**
 * 打包：瓶子（食物包装的实现）
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/22
 * @since 1.0.0
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
