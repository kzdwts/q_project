package top.kangyong.study01.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/12/18 20:20
 * @version: v1.0
 */
public class AopTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("Hello World");
        helloWorld.sayHelloWorld();
    }

}
