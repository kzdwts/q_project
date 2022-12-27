package top.kangyong.study02.design.pattern.behaviormode.responsibility;

/**
 * 请假条类
 * <p>
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/12/26
 * @since 1.0.0
 */
public class LeaveRequest {

    // 姓名
    private String name;
    // 天数
    private int num;
    // 内容
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
