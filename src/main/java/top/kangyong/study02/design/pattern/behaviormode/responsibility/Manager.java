package top.kangyong.study02.design.pattern.behaviormode.responsibility;

/**
 * 经理长类（具体的处理者）
 * <p>
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/12/27
 * @since 1.0.0
 */
public class Manager extends Handler {

    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent());
        System.out.println("经理审批：同意");
    }

}
