package top.kangyong.study02.design.pattern.behaviormode.mediator;

/**
 * test
 * <p>
 * 中介者模式
 *
 * @author Kang Yong
 * @date 2023/1/27
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 中介者对象
        MediatorStructure mediatorStructure = new MediatorStructure();

        // 租房者对象
        Tenant tenant = new Tenant("李四", mediatorStructure);
        // 房主对象
        HouseOwner houseOwner = new HouseOwner("房东沙阿姨", mediatorStructure);

        // 中介者要知道具体的房主和租房者
        mediatorStructure.setHouseOwner(houseOwner);
        mediatorStructure.setTenant(tenant);

        //
        tenant.constact("我要租三室的房子");
        houseOwner.constact("现在有三居室的房子，你要租吗");

    }

}
