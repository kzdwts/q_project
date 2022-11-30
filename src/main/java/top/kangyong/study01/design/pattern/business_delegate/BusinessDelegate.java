package top.kangyong.study01.design.pattern.business_delegate;

/**
 * 业务代表
 * <p>
 * 业务代表模式
 *
 * @author Kang Yong
 * @date 2022/11/30
 * @since 1.0.0
 */
public class BusinessDelegate {

    private BusinessLookUp businessLookUp = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        BusinessService businessService = businessLookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
