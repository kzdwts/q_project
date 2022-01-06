package top.kangyong.study01.threadtest.demo01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/8/30 17:21
 * @version: v1.0
 */
public class TestSaleWindow {

    public static void main(String[] args) {
        SaleWindow saleWindow = new SaleWindow();

        // 开启两个卖票窗口
        Thread sw1 = new Thread(saleWindow);
        Thread sw2 = new Thread(saleWindow);

        // 给个名字
        sw1.setName("王丽丽");
        sw2.setName("雨婷");

        // 启动卖票功能
        sw1.start();
        sw2.start();
    }
}
