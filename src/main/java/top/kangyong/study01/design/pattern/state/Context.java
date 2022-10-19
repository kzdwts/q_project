package top.kangyong.study01.design.pattern.state;

/**
 * 状态模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/19
 * @since 1.0.0
 */
public class Context {

    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
