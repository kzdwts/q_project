package top.kangyong.study01.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * <p>
 * 行为型模式
 *
 * @author Kang Yong
 * @date 2022/10/9
 * @since 1.0.0
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
