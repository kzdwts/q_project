package top.kangyong.study01.design.pattern.adapter;

/**
 * 媒体适配器
 *
 * @author Kang Yong
 * @date 2022/7/5
 * @since 1.0.0
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    /**
     * 播放
     *
     * @param audioType {@link String}
     * @param fileName  {@link String}
     * @author Kang Yong
     * @date 2022/7/5
     */
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }
}
