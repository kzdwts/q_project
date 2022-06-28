package top.kangyong.study02.design.principles.openclose;

/**
 * 搜狗输入法
 * <p>
 * 设计原则：开闭原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class SougouInput {

    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
