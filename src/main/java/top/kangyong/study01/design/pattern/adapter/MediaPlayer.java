package top.kangyong.study01.design.pattern.adapter;

/**
 * 媒体播放器
 * <p>
 * 适配器模式
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public interface MediaPlayer {

    /**
     * 播放
     *
     * @param audioType {@link String}
     * @param fileName  {@link String}
     * @author Kang Yong
     * @date 2022/6/28
     */
    public void play(String audioType, String fileName);
}
