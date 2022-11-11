package top.kangyong.study01.design.pattern.template;

/**
 * 足球游戏
 * <p>
 * 模板模式
 *
 * @author Kang Yong
 * @date 2022/11/10
 * @since 1.0.0
 */
public class Football extends Game {
    /**
     * 初始化游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    @Override
    void initialize() {
        System.out.println("Football game initialized! Start playing");
    }

    /**
     * 开始游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    @Override
    void startPlay() {
        System.out.println("Football game started! Enjoy the game!");
    }

    /**
     * 结束游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    @Override
    void endPlay() {
        System.out.println("Football Game Over!");
    }
}
