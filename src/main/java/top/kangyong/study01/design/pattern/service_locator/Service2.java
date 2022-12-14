package top.kangyong.study01.design.pattern.service_locator;

/**
 * 实体服务
 *
 * @author Kang Yong
 * @date 2022/12/12
 * @since 1.0.0
 */
public class Service2 implements Service {

    @Override
    public String getName() {
        return "service2";
    }

    @Override
    public void execute() {
        System.out.println("service2 executing");
    }

}
