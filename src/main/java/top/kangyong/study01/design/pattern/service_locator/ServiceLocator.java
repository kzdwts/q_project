package top.kangyong.study01.design.pattern.service_locator;

/**
 * 创建服务定位器
 * <p>
 * 服务定位器模式
 *
 * @author Kang Yong
 * @date 2022/12/15
 * @since 1.0.0
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public Service getService(String jndiName) {
        Service service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service lookupService = (Service) context.lookup(jndiName);
        cache.addService(lookupService);

        return lookupService;
    }
}
