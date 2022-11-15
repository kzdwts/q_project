package top.kangyong.study02.design.pattern.structuralmode.combination;

/**
 * test 打印菜单
 * <p>
 * 组合模式
 * <p>
 * 使用场景：凡是有树形结构的地方都可以使用组合模式
 * <p>
 * 分类：①透明组合 ②安全组合
 *
 * @author Kang Yong
 * @date 2022/11/13
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 创建菜单树
        MenuComponent menu1 = new Menu("菜单管理", 2);
        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("展开菜单", 3));
        menu1.add(new MenuItem("编辑菜单", 3));
        menu1.add(new MenuItem("删除菜单", 3));
        menu1.add(new MenuItem("新增菜单", 3));

        MenuComponent menu2 = new Menu("权限配置", 2);
        menu2.add(new MenuItem("页面访问", 3));
        menu2.add(new MenuItem("提交保存", 3));

        MenuComponent menu3 = new Menu("角色管理", 2);
        menu3.add(new MenuItem("页面访问", 3));
        menu3.add(new MenuItem("新增角色", 3));
        menu3.add(new MenuItem("修改角色", 3));

        // 根节点
        MenuComponent component = new Menu("系统管理", 1);
        component.add(menu1);
        component.add(menu2);
        component.add(menu3);

        component.print();
    }

}
