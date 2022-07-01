package top.kangyong.study01.design.pattern.adapter;

/**
 * vlc播放器
 * <p>
 * 适配器模式
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {

    }
}
