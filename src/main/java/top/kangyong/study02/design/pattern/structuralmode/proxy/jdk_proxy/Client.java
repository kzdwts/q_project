package top.kangyong.study02.design.pattern.structuralmode.proxy.jdk_proxy;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/26
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 获取代理对象
        // 1、创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory();
        // 2、使用factory对象的方法获取代理对象
        SellTickets sellTickets = proxyFactory.getProxyObject();
        // 3、调用类调用的方法
        sellTickets.sell();
    }
}
