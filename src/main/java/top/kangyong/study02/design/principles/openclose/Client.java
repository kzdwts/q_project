package top.kangyong.study02.design.principles.openclose;

/**
 * 输入法测试类
 * <p>
 * 设计原则：开闭原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        SougouInput sougouInput = new SougouInput();
        sougouInput.setSkin(new HeimaSkin());
        sougouInput.display();

        sougouInput.setSkin(new DefaultSkin());
        sougouInput.display();


    }
}
