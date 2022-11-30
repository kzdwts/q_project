package top.kangyong.study01.design.pattern.business_delegate;

/**
 * client
 * <p>
 * 业务代表模式
 *
 * @author Kang Yong
 * @date 2022/11/30
 * @since 1.0.0
 */
public class Client {

   private BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }
}
