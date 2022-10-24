package top.kangyong.study02.design.pattern.structuralmode.proxy.static_proxy;

/**
 * 静态代理 火车站类
 * <p>
 * 结构型模式
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
