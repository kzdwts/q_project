package top.kangyong.study01.design.pattern.null_object;

/**
 * 空对象模式
 *
 * @author Kang Yong
 * @date 2022/10/31
 * @since 1.0.0
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
