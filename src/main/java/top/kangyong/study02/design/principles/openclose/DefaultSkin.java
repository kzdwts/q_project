package top.kangyong.study02.design.principles.openclose;

/**
 * 默认皮肤
 * <p>
 * 设计原则：开闭原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class DefaultSkin extends AbstractSkin {

    @Override
    public void display() {
        System.out.println("默认皮肤：绿色");
    }

}
