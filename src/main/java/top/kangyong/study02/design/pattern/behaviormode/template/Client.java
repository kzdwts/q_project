package top.kangyong.study02.design.pattern.behaviormode.template;

/**
 * test
 * <p>
 * 模板方法模式
 *
 * @author Kang Yong
 * @date 2022/11/28
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        // 炒包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();

        // 炒菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }

}
