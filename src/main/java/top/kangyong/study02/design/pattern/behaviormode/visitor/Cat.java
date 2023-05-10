package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * 具体元素角色类（宠物猫）
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/4/27
 * @since 1.0.0
 */
public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this); // 访问者给宠物猫喂食
        System.out.println("好好吃，喵。。。");
    }

}
