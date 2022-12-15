package top.kangyong.study01.design.pattern.service_locator;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建缓存 Cache。
 * <p>
 * 服务定位器模式
 *
 * @author Kang Yong
 * @date 2022/12/15
 * @since 1.0.0
 */
public class Cache {

    private List<Service> serviceList;

    public Cache() {
        serviceList = new ArrayList<>();
    }

    public Service getService(String serviceName) {
        for (Service service : serviceList) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("return caching service: " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;

        for (Service service : serviceList) {
            if (service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }

        if (!exists) {
            serviceList.add(newService);
        }
    }
}
