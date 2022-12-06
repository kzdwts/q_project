package top.kangyong.study01.design.pattern.front_controller;

/**
 * 前端控制器
 * <p>
 * 前端控制器模式
 *
 * @author Kang Yong
 * @date 2022/12/6
 * @since 1.0.0
 */
public class FrontController {

    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    public boolean isAuthenticUser() {
        System.out.println("user is authenticated successfully.");
        return true;
    }

    public void trackRequest(String request) {
        System.out.println("page request:" + request);
    }

    public void dispatcherRequest(String request) {
        // 记录一个请求
        trackRequest(request);

        // 校验
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }

    }

}
