package top.kangyong.study02.design.pattern.structuralmode.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * 代理对象工厂，用来生产代理对象
 *
 * @author Kang Yong
 * @date 2022/10/30
 * @since 1.0.0
 */
public class ProxyFactory {

    public TrainStation getProxyObject() {
        // 创建enhancer对象，相当于JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);

        // 设置回调函数

        // 创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }
}
