package top.kangyong.study01.design.pattern.front_controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * test
 * <p>
 * 前端控制器模式
 *
 * @author Kang Yong
 * @date 2022/12/6
 * @since 1.0.0
 */
public class FrontControllerPatternDemo {

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatcherRequest("HOME");

        System.out.println("================");
        frontController.dispatcherRequest("STUDENT");
    }

}
