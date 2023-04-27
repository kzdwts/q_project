package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/4/27
 * @since 1.0.0
 */
public interface Animal {

    void accept(Person person);
}
