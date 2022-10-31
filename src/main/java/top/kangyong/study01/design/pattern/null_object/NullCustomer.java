package top.kangyong.study01.design.pattern.null_object;

/**
 * 空对象模式
 *
 * @author Kang Yong
 * @date 2022/10/31
 * @since 1.0.0
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

}
