package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * 扩展抽象画角色 Windows操作系统
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/11/11
 * @since 1.0.0
 */
public class Windows extends OperatingSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
