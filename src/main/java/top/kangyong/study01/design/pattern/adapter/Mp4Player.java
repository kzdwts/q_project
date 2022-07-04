package top.kangyong.study01.design.pattern.adapter;

/**
 * MP4播放器
 *
 * @author Kang Yong
 * @date 2022/7/4
 * @since 1.0.0
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // 啥也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 file. Name:" + fileName);
    }
}
