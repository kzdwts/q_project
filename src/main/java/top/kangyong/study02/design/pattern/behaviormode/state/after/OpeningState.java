package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 开启门状态
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class OpeningState extends LiftState {

    @Override
    public void open() {
        System.out.println("电梯门已开启。。。");
    }

    @Override
    public void close() {
        this.context.setLiftState(Context.CLOSING_STATE);
        this.context.close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
