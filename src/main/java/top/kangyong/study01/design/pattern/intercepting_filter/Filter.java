package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * 过滤器接口
 * <p>
 * 拦截过滤器模式
 *
 * @author Kang Yong
 * @date 2022/12/7
 * @since 1.0.0
 */
public interface Filter {

    void execute(String request);
}
