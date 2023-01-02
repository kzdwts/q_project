package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 运行状态
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class RunningState extends LiftState {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }

    @Override
    public void stop() {
        this.context.setLiftState(Context.STOPPING_STATE);
        this.context.stop();
    }
}
