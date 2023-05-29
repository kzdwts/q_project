package top.kangyong.study02.design.pattern.behaviormode.memento.black_box;

import lombok.Data;
import lombok.ToString;
import top.kangyong.study02.design.pattern.behaviormode.memento.white_box.RoleStateMemento;

/**
 * 备忘录角色类
 * <p>
 * 行为型模式-备忘录模式（黑盒）
 *
 * @author Kang Yong
 * @date 2023/5/27
 * @since 1.0.0
 */
@Data
@ToString
public class RoleStateCaretaker {

    // 声明RoleStateMemento类型的变量
    private Memento memento;


}
