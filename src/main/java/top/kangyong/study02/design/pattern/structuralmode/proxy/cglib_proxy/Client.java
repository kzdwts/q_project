package top.kangyong.study02.design.pattern.structuralmode.proxy.cglib_proxy;

/**
 * cglib代理模式test
 *
 * @author Kang Yong
 * @date 2022/11/2
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();

        TrainStation trainStation = proxyFactory.getProxyObject();

        trainStation.sell();
    }

}
