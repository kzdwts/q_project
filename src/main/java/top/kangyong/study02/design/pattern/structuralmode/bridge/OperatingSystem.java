package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * 抽象的操作系统类（抽象画角色）
 *
 * @author Kang Yong
 * @date 2022/11/11
 * @since 1.0.0
 */
public abstract class OperatingSystem {

    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * 播放
     *
     * @param fileName {@link String}
     * @author Kang Yong
     * @date 2022/11/11
     */
    public abstract void play(String fileName);

}
