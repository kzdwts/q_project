package top.kangyong.study02.design.pattern.structuralmode.proxy.static_proxy;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/24
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();

        proxyPoint.sell();
    }

}
