package top.kangyong.study01.design.pattern.front_controller;

/**
 * 调度器
 * <p>
 * 前端控制器模式
 *
 * @author Kang Yong
 * @date 2022/12/5
 * @since 1.0.0
 */
public class Dispatcher {

    private HomeView homeView;
    private StudentView studentView;

    public Dispatcher() {
        this.homeView = new HomeView();
        this.studentView = new StudentView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }

}
