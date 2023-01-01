package top.kangyong.study02.design.pattern.behaviormode.responsibility.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk责任链模式
 *
 * @author Kang Yong
 * @date 2023/1/1
 * @since 1.0.0
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();

    private Integer index = 0;

    /**
     * 链式调用
     *
     * @param filter {@link Filter}
     * @return {@link FilterChain}
     * @author Kang Yong
     * @date 2023/1/1
     */
    public FilterChain FilterChain(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    /**
     * 过滤
     *
     * @param req {@link Request}
     * @param res {@link Response}
     * @author Kang Yong
     * @date 2023/1/1
     */
    public void doFilter(Request req, Response res) {
        if (index == filters.size()) {
            return;
        }

        Filter filter = filters.get(index);
        index++;
        filter.doFilter(req, res, this);
    }
}
