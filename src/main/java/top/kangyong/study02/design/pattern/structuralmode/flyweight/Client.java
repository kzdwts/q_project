package top.kangyong.study02.design.pattern.structuralmode.flyweight;

/**
 * test
 * <p>
 * 享元模式
 * <p>
 * 优点：
 * 极大减少内存中相似或相同对象数量，节约系统资源，提高系统性能
 * 享元模式中的外部相对独立，且不影响内部状态
 *
 * @author Kang Yong
 * @date 2022/11/21
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        BoxFactory factory = BoxFactory.getInstance();

        // 获取I图形
        AbstractBox iBox = factory.getShape("I");
        iBox.display("灰色");

        // 获取L图形
        AbstractBox lBox = factory.getShape("L");
        lBox.display("红色");

        // 获取O图形
        AbstractBox oBox = factory.getShape("O");
        oBox.display("绿色");

        AbstractBox oBox2 = factory.getShape("O");
        oBox2.display("墨绿色");

        System.out.println(oBox == oBox2);
    }

}
