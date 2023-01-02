package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 抽象状态类
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public abstract class LiftState {

    // 环境角色，封装状态变化引起的功能变化
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 电梯开门动作
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    public abstract void open();

    /**
     * 电梯关门动作
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    public abstract void close();

    /**
     * 电梯运行动作
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    public abstract void run();

    /**
     * 电梯停止动作
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    public abstract void stop();

}
