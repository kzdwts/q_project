package top.kangyong.study01.design.pattern.state;

/**
 * 状态模式
 *
 * @author Kang Yong
 * @date 2022/10/22
 * @since 1.0.0
 */
public class StatePatternDemo {

    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }

}
