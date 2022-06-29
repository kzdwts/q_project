package top.kangyong.study02.design.principles.openclose;

/**
 * 黑马皮肤
 * <p>
 * 设计原则：开闭原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class HeimaSkin extends AbstractSkin {

    @Override
    public void display() {
        System.out.println("黑马皮肤：黑色");
    }
}
