package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * Mac操作系统 扩展抽象化角色
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/11/11
 * @since 1.0.0
 */
public class Mac extends OperatingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
