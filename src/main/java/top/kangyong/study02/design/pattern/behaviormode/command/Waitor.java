package top.kangyong.study02.design.pattern.behaviormode.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员类（属于请求者角色）
 * <p>
 * 命令模式
 *
 * @author Kang Yong
 * @date 2022/12/25
 * @since 1.0.0
 */
public class Waitor {

    // 持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd) {
        commands.add(cmd);
    }

    /**
     * 发起命令
     *
     * @author Kang Yong
     * @date 2022/12/25
     */
    public void orderUp() {
        System.out.println("美女服务员：大厨，订单来了。。。");
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }
}
