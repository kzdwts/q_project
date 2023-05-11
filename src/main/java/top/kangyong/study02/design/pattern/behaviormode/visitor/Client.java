package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * 行为型模式-访问者模式
 *
 * 优点：
 * 扩展性好
 * 复用性好
 *
 * 缺点：
 * 对象结构变化很困难
 * 违反了依赖倒置原则
 *
 * @author Kang Yong
 * @date 2023/5/11
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 创建Home对象
        Home home = new Home();

        // 添加元素到Home对象中
        home.add(new Dog());
        home.add(new Cat());

        // 创建主人对象
        Owner owner = new Owner();
        // 主人喂食所有的宠物
        home.action(owner);
    }
}
