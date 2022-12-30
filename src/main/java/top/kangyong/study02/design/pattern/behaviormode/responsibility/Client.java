package top.kangyong.study02.design.pattern.behaviormode.responsibility;

/**
 * test
 * <p>
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/12/30
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        LeaveRequest leave = new LeaveRequest("小明", 7, "家里有事");

        // 处理者
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        // 请假提交
        groupLeader.submit(leave);

    }

}
