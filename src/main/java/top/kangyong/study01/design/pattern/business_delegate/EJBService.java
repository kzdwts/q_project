package top.kangyong.study01.design.pattern.business_delegate;

/**
 * 业务代表模式
 *
 * @author Kang Yong
 * @date 2022/11/25
 * @since 1.0.0
 */
public class EJBService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("");
    }
}
