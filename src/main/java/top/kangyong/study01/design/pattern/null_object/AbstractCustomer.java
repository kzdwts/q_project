package top.kangyong.study01.design.pattern.null_object;

/**
 * 空对象模式
 *
 * @author Kang Yong
 * @date 2022/10/31
 * @since 1.0.0
 */
public abstract class AbstractCustomer {

    protected String name;

    public abstract boolean isNil();

    public abstract String getName();
}
