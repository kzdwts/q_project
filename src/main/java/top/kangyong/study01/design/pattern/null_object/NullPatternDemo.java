package top.kangyong.study01.design.pattern.null_object;

/**
 * 空对象模式
 *
 * @author Kang Yong
 * @date 2022/11/1
 * @since 1.0.0
 */
public class NullPatternDemo {

    public static void main(String[] args) {
        AbstractCustomer c1 = CustomerFactory.getCustomer("wanglili");
        AbstractCustomer c2 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer c3 = CustomerFactory.getCustomer("Joe");
        AbstractCustomer c4 = CustomerFactory.getCustomer("Jane");

        System.out.println("customer:");
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());
    }
}
