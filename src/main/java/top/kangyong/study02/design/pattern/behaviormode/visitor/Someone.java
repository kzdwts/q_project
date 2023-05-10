package top.kangyong.study02.design.pattern.behaviormode.visitor;

/**
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/4/27
 * @since 1.0.0
 */
public class Someone implements Person {
    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
