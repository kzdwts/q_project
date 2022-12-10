package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2022/12/10
 * @since 1.0.0
 */
public class Client {

    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }

}
