package top.kangyong.study02.design.pattern.structuralmode.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单类：属于树枝节点角色
 * <p>
 * 组合模式
 *
 * @author Kang Yong
 * @date 2022/11/13
 * @since 1.0.0
 */
public class Menu extends MenuComponent {

    // 菜单可以有多个子菜单或子菜单项
    private List<MenuComponent> menuComponentList = new ArrayList<>();

    // 构造方法
    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponentList.get(i);
    }

    @Override
    public void print() {
        // 打印菜单名称
        System.out.println(name);

        // 打印子菜单或者子菜单项名称
        for (MenuComponent component : menuComponentList) {
            component.print();
        }
    }
}
