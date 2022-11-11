package top.kangyong.study01.design.pattern.template;

/**
 * test
 * <p>
 * 模板模式
 *
 * @author Kang Yong
 * @date 2022/11/10
 * @since 1.0.0
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();

        game = new Football();
        game.play();
    }

}
