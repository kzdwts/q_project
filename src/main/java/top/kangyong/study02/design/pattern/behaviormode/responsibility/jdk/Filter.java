package top.kangyong.study02.design.pattern.behaviormode.responsibility.jdk;

/**
 * jdk责任链模式
 *
 * @author Kang Yong
 * @date 2023/1/1
 * @since 1.0.0
 */
public interface Filter {

    /**
     * 过滤
     *
     * @param req {@link Request}
     * @param res {@link Response}
     * @param c   {@link FilterChain}
     * @author Kang Yong
     * @date 2023/1/1
     */
    void doFilter(Request req, Response res, FilterChain c);

}
