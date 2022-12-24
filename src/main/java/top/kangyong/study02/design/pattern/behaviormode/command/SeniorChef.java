package top.kangyong.study02.design.pattern.behaviormode.command;

/**
 * 厨师类
 * <p>
 * 命令模式
 *
 * @author Kang Yong
 * @date 2022/12/24
 * @since 1.0.0
 */
public class SeniorChef {

    public void makeFood(String name, int num) {
        System.out.println(num + "份" + name);
    }
}
