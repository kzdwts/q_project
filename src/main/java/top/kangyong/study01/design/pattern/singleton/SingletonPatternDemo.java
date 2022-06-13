package top.kangyong.study01.design.pattern.singleton;

/**
 * 单例模式
 *
 * @author Kang Yong
 * @date 2022/6/13
 * @since 1.0.0
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {
//        SingletonObject instance = new SingletonObject();

        SingletonObject singletonObject = SingletonObject.getInstance();
        singletonObject.showMessage();
    }
}
