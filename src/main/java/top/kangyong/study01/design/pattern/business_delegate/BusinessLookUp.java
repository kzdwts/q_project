package top.kangyong.study01.design.pattern.business_delegate;

/**
 * 业务查询服务
 * <p>
 * 业务代表模式
 *
 * @author Kang Yong
 * @date 2022/11/30
 * @since 1.0.0
 */
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }

}
