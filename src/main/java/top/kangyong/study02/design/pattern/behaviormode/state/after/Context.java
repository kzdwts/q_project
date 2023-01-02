package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 环境角色
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class Context {

    // 定义几个状态
    public static final OpeningState OPENING_STATE = new OpeningState();
    public static final ClosingState CLOSING_STATE = new ClosingState();
    public static final RunningState RUNNING_STATE = new RunningState();
    public static final StoppingState STOPPING_STATE = new StoppingState();

    // 当前电梯状态
    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        // 当前环境
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
