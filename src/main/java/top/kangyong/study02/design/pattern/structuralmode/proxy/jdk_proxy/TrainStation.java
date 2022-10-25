package top.kangyong.study02.design.pattern.structuralmode.proxy.jdk_proxy;

/**
 * JDK代理模式 火车站卖票
 *
 * @author Kang Yong
 * @date 2022/10/24
 * @since 1.0.0
 */
public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }

}
