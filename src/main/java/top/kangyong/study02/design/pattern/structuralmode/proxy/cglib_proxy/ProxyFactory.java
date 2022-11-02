package top.kangyong.study02.design.pattern.structuralmode.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象工厂，用来生产代理对象
 * <p>
 * 结构型模式 cglib动态代理
 *
 * @author Kang Yong
 * @date 2022/10/30
 * @since 1.0.0
 */
public class ProxyFactory implements MethodInterceptor {

    public TrainStation getProxyObject() {
        // 创建enhancer对象，相当于JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);

        // 设置回调函数
        enhancer.setCallback(this);

        // 创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行了");
        return null;
    }
}
