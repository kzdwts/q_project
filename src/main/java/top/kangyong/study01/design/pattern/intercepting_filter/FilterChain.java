package top.kangyong.study01.design.pattern.intercepting_filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链
 * <p>
 * 拦截过滤器模式
 *
 * @author Kang Yong
 * @date 2022/12/9
 * @since 1.0.0
 */
public class FilterChain {

    private List<Filter> filterList = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filterList) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
