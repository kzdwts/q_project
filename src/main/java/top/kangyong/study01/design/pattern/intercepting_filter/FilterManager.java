package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * 过滤管理器
 * <p>
 * 拦截过滤器模式
 *
 * @author Kang Yong
 * @date 2022/12/10
 * @since 1.0.0
 */
public class FilterManager {

    private FilterChain filterChain;

    public FilterManager(Target target) {
        this.filterChain = new FilterChain();
        this.filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
