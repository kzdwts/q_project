package top.kangyong.study01.design.pattern.service_locator;

/**
 * 为 JNDI 查询创建 InitialContext。
 * <p>
 * 服务定位器模式
 *
 * @author Kang Yong
 * @date 2022/12/14
 * @since 1.0.0
 */
public class InitialContext {

    public Object lookup(String jndiName) {
        if (jndiName.equalsIgnoreCase("service1")) {
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1();
        } else if (jndiName.equalsIgnoreCase("service2")) {
            System.out.println("Looking up and creating a new Service2 object");
            return new Service2();
        }
        return null;
    }
}
