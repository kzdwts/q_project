package top.kangyong.study01.design.pattern.null_object;

/**
 * 空对象模式：客户工厂
 *
 * @author Kang Yong
 * @date 2022/10/31
 * @since 1.0.0
 */
public class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }

        return new NullCustomer();
    }
}
