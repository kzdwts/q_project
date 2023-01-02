package top.kangyong.study02.design.pattern.behaviormode.state.before;

/**
 * test
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.OPENING_STATE);

        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }

}
