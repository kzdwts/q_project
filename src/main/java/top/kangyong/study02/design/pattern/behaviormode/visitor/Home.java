package top.kangyong.study02.design.pattern.behaviormode.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 * <p>
 * 行为型模式-访问者模式
 *
 * @author Kang Yong
 * @date 2023/5/10
 * @since 1.0.0
 */
public class Home {

    // 声明一个集合对象，用来存储元素对象
    private List<Animal> nodeList = new ArrayList<>();

    /**
     * 添加元素
     *
     * @param animal {@link Animal}
     * @author Kang Yong
     * @date 2023/5/11
     */
    public void add(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        for (Animal animal : nodeList) {
            // 让访问者访问每一个元素
            animal.accept(person);
        }
    }

}
