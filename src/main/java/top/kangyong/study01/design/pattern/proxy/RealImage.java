package top.kangyong.study01.design.pattern.proxy;

/**
 * 代理模式
 * <p>
 * 结构型模式
 *
 * @author Kang Yong
 * @date 2022/9/6
 * @since 1.0.0
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        this.loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Display " + fileName);
    }
}
