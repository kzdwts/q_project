package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 关闭门状态
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class ClosingState extends LiftState {
    @Override
    public void open() {
        this.context.setLiftState(Context.OPENING_STATE);
        this.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    @Override
    public void run() {
        this.context.setLiftState(Context.RUNNING_STATE);
        this.context.run();
    }

    @Override
    public void stop() {
        this.context.setLiftState(Context.STOPPING_STATE);
        this.context.stop();
    }
}
