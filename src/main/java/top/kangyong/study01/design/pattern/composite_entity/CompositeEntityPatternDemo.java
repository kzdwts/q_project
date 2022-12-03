package top.kangyong.study01.design.pattern.composite_entity;

/**
 * test
 * <p>
 * 组合实体模式
 *
 * @author Kang Yong
 * @date 2022/12/2
 * @since 1.0.0
 */
public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        Client client = new Client();

        client.setData("Test", "wanglili");
        client.printData();

        client.setData("Second Test", "chuxiaojiao");
        client.printData();
    }

}
