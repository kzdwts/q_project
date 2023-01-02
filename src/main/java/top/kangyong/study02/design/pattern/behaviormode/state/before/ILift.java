package top.kangyong.study02.design.pattern.behaviormode.state.before;

/**
 * 电梯接口
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public interface ILift {

    // 状态
    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;


    /**
     * 开门
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    void open();

    /**
     * 关门
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    void close();

    /**
     * 运行
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    void run();

    /**
     * 停止
     *
     * @author Kang Yong
     * @date 2023/1/2
     */
    void stop();
}
