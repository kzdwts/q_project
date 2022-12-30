package top.kangyong.study02.design.pattern.behaviormode.responsibility;

/**
 * 总经理类（具体的处理者）
 * <p>
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/12/27
 * @since 1.0.0
 */
public class GeneralManager extends Handler {

    public GeneralManager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent());
        System.out.println("总经理审批：同意");
    }

}
