package top.kangyong.study02.design.pattern.behaviormode.responsibility;

/**
 * 抽象处理者
 * <p>
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/12/26
 * @since 1.0.0
 */
public abstract class Handler {

    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    // 该领导处理的请求天数区间
    private int numStart;
    private int numEnd;

    // 声明后续者（声明上级领导）
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    /**
     * 设置上级领导对象
     *
     * @param nextHandler {@link Handler}
     * @author Kang Yong
     * @date 2022/12/27
     */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 各级领导处理请假条的的方法
     *
     * @param leave {@link LeaveRequest}
     * @author Kang Yong
     * @date 2022/12/27
     */
    protected abstract void handleLeave(LeaveRequest leave);

    /**
     * 提交请假条
     *
     * @param leave {@link LeaveRequest}
     * @author Kang Yong
     * @date 2022/12/27
     */
    public final void submit(LeaveRequest leave) {
        // 该领导进行审批
        this.handleLeave(leave);

        if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            this.nextHandler.submit(leave);
        } else {
            System.out.println("流程结束！");
        }
    }

}
