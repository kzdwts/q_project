package top.kangyong.study01.design.pattern.builder;

/**
 * 打包：纸盒（创建实现 Packing 接口的实体类）
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/21
 * @since 1.0.0
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
