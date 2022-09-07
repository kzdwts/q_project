package top.kangyong.study01.design.pattern.proxy;

/**
 * 代理模式 测试
 * <p>
 * 结构型模式
 *
 * @author Kang Yong
 * @date 2022/9/7
 * @since 1.0.0
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("abc.png");

        // 第一次需要加载磁盘数据
        image.display();

        // 第二次直接使用
        image.display();
    }
}
