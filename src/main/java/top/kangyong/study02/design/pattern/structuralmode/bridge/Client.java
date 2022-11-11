package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * test
 *
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/11/11
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        OperatingSystem os = new Mac(new AviFile());

        // 使用操作系统播放视频文件
        os.play("战狼3");
    }
}
