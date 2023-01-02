package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new RunningState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }

}
