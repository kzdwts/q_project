package top.kangyong.study02.design.principles.dimit.before;

/**
 * 明星类
 * <p>
 * 迪米特法则
 *
 * @author Kang Yong
 * @date 2022/7/23
 * @since 1.0.0
 */
public class Star {

    /**
     * 名字
     */
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
