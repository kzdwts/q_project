package top.kangyong.study02.design.pattern.structuralmode.combination;

/**
 * 菜单项类：属于叶子结点
 *
 * @author Kang Yong
 * @date 2022/11/13
 * @since 1.0.0
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, int level) {
        this.name = name;
    }

    @Override
    public void print() {
        // 打印菜单项的名称
        System.out.println(name);
    }
}
