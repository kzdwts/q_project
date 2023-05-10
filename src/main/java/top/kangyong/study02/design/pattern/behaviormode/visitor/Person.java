package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/4/27
 * @since 1.0.0
 */
public interface Person {

    /**
     * 功能: 喂食宠物猫
     *
     * @param cat {@link Cat}
     * @author Kang Yong
     * @date 2023/5/10
     */
    void feed(Cat cat);

    /**
     * 功能: 喂食宠物狗
     *
     * @param dog {@link Dog}
     * @author Kang Yong
     * @date 2023/5/10
     */
    void feed(Dog dog);

}
