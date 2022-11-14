package top.kangyong.study02.design.pattern.structuralmode.combination;

/**
 * 菜单组件：属于抽象根节点
 * <p>
 * 组合模式
 *
 * @author Kang Yong
 * @date 2022/11/13
 * @since 1.0.0
 */
public abstract class MenuComponent {

    // 菜单组件的名称
    protected String name;

    // 菜单组件的层级
    protected int level;

    /**
     * 添加子菜单
     *
     * @param menuComponent {@link MenuComponent}
     * @author Kang Yong
     * @date 2022/11/13
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 移出菜子菜单
     *
     * @param menuComponent {@link MenuComponent}
     * @author Kang Yong
     * @date 2022/11/13
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取指定的子菜单
     *
     * @param i {@link int}
     * @author Kang Yong
     * @date 2022/11/13
     */
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取菜单或者菜单项的名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/11/13
     */
    public String getName() {
        return name;
    }

    /**
     * 打印菜单名称（包含子菜单和子菜单项）
     *
     * @author Kang Yong
     * @date 2022/11/13
     */
    public abstract void print();
}
