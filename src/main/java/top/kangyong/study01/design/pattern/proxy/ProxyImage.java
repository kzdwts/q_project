package top.kangyong.study01.design.pattern.proxy;

/**
 * 代理模式
 * <p>
 * 结构型模式
 *
 * @author Kang Yong
 * @date 2022/9/7
 * @since 1.0.0
 */
public class ProxyImage implements Image {

    private String fileName;

    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
