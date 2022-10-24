package top.kangyong.study02.design.pattern.structuralmode.proxy.static_proxy;

/**
 * 售票代理点
 * <p>
 * 结构型模式
 *
 * @author Kang Yong
 * @date 2022/10/24
 * @since 1.0.0
 */
public class ProxyPoint implements SellTickets {

    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代售点收取一些服务费");
        trainStation.sell();
    }
}
