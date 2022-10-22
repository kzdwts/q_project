package top.kangyong.study02.design.pattern.creatormode.builder.demo01;

/**
 * 指挥者类
 * <p>
 * 创建者模式
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class Director {

    /**
     * 声明builder类的对象
     */
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 组装自行车
     *
     * @return {@link Bike}
     * @author Kang Yong
     * @date 2022/10/23
     */
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
