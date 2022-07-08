package top.kangyong.study01.design.pattern.adapter;

/**
 * 播放器
 *
 * @author Kang Yong
 * @date 2022/7/8
 * @since 1.0.0
 */
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    /**
     * 播放
     *
     * @param audioType {@link String}
     * @param fileName  {@link String}
     * @author Kang Yong
     * @date 2022/6/28
     */
    @Override
    public void play(String audioType, String fileName) {
        // mp3
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name:" + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            // mediaAdapter 提供了播放其他文件格式的支持
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("其它类型播放器不支持");
        }
    }
}
