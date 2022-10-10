package top.kangyong.study01.design.pattern.memento;

/**
 * 备忘录模式
 * <p>
 * 行为型模式
 * @author Kang Yong
 * @date 2022/10/5
 * @since 1.0.0
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
