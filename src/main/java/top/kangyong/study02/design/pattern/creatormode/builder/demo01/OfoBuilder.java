package top.kangyong.study02.design.pattern.creatormode.builder.demo01;

/**
 * ofo单车构建者
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
