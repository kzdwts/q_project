package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * test
 * <p>
 * 拦截过滤器模式
 *
 * @author Kang Yong
 * @date 2022/12/11
 * @since 1.0.0
 */
public class InterceptingFilterDemo {

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }

}
