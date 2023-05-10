package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * 具体元素角色类（宠物狗）
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/4/27
 * @since 1.0.0
 */
public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，汪汪汪。。。");
    }
}
