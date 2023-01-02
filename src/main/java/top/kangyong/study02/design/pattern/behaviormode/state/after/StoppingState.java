package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 停止状态
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class StoppingState extends LiftState {
    @Override
    public void open() {
        this.context.setLiftState(Context.OPENING_STATE);
        this.context.open();
    }

    @Override
    public void close() {
        this.context.setLiftState(Context.CLOSING_STATE);
        this.context.close();
    }

    @Override
    public void run() {
        this.context.setLiftState(Context.RUNNING_STATE);
        this.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
