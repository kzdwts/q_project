package top.kangyong.study01.spring.aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/12/18 20:28
 * @version: v1.0
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World!");
        // 抛出异常
        String str = null;
        str.substring(1);
    }
}
