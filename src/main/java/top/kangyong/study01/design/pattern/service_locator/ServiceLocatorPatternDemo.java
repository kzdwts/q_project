package top.kangyong.study01.design.pattern.service_locator;

/**
 * 服务定位器模式
 *
 * @author Kang Yong
 * @date 2022/12/17
 * @since 1.0.0
 */
public class ServiceLocatorPatternDemo {

    public static void main(String[] args) {
        Service service = ServiceLocator.getService("service1");
        service.execute();

        service = ServiceLocator.getService("service2");
        service.execute();

        service = ServiceLocator.getService("service1");
        service.execute();

        service = ServiceLocator.getService("service2");
        service.execute();
    }
}
