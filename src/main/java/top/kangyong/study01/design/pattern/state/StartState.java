package top.kangyong.study01.design.pattern.state;

/**
 * 状态模式
 *
 * @author Kang Yong
 * @date 2022/10/20
 * @since 1.0.0
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "start state";
    }
}
