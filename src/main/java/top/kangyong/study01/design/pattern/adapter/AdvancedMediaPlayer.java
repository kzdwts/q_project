package top.kangyong.study01.design.pattern.adapter;

/**
 * 高级媒体播放器
 *
 * @author Kang Yong
 * @date 2022/6/29
 * @since 1.0.0
 */
public interface AdvancedMediaPlayer {

    void playVlc(String fileName);

    void playMp4(String fileName);
}
