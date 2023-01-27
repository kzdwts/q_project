package top.kangyong.study02.design.pattern.behaviormode.mediator;

/**
 * 具体的中介者角色类
 *
 * @author Kang Yong
 * @date 2023/1/26
 * @since 1.0.0
 */
public class MediatorStructure extends Mediator {

    // 聚合房主和租房者对象

    private HouseOwner houseOwner;
    private Tenant tenant;

    @Override
    public void constact(String message, Person person) {
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
