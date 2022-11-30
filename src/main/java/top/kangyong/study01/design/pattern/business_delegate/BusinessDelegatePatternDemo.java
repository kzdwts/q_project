package top.kangyong.study01.design.pattern.business_delegate;

/**
 * test
 * <p>
 * 业务代表模式
 *
 * @author Kang Yong
 * @date 2022/11/30
 * @since 1.0.0
 */
public class BusinessDelegatePatternDemo {

    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();

        Client client = new Client(businessDelegate);

        businessDelegate.setServiceType("EJB");
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();

    }
}
