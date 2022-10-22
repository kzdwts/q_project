package top.kangyong.study02.design.pattern.creatormode.builder.demo01;

/**
 * 摩拜单车
 * <p>
 * 创建者模式
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
