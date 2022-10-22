package top.kangyong.study02.design.pattern.creatormode.builder.demo01;

/**
 * 产品对象-自行车
 * <p>
 * 创建者模式
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class Bike {

    /**
     * 车架
     */
    private String frame;
    /**
     * 车坐
     */
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
