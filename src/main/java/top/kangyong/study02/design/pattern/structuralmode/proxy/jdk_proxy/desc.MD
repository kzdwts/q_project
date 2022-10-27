* 使用arthas命令提取出动态代理对象的源码

```shell
jad com.sun.proxy.$Proxy0

```

```java
public final class $Proxy0 extends Proxy implements SellTickets {

    private static Method m3;

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    public final void sell() {
        this.h.invoke(this, m3, null);
    }

    static {
        m3 = Class.forName("top.kangyong.study02.design.pattern.structuralmode.proxy.jdk_proxy.SellTickets")
                .getMethod("sell", new Class[0]);
    }
}

public class Proxy {
    protected InvocationHandler h;
}
```