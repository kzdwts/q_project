package top.kangyong.study01.design.pattern.template;

/**
 * 模板
 * <p>
 * 模板模式
 *
 * @author Kang Yong
 * @date 2022/11/8
 * @since 1.0.0
 */
public abstract class Game {

    /**
     * 初始化游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    abstract void initialize();

    /**
     * 开始游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    abstract void startPlay();

    /**
     * 结束游戏
     *
     * @author Kang Yong
     * @date 2022/11/8
     */
    abstract void endPlay();

    public final void play() {

        // 初始化
        initialize();

        // 开始
        startPlay();

        // 结束
        endPlay();
    }

}
