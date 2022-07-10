package top.kangyong.study01.design.pattern.adapter;

/**
 * 适配器模式
 *
 * @author Kang Yong
 * @date 2022/7/8
 * @since 1.0.0
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");

    }
}
