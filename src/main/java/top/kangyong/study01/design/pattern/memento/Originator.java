package top.kangyong.study01.design.pattern.memento;

/**
 * 备忘录模式
 *
 * @author Kang Yong
 * @date 2022/10/6
 * @since 1.0.0
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
