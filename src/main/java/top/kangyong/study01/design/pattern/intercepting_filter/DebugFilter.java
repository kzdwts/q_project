package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * 实体过滤器
 * <p>
 * 拦截过滤器模式
 *
 * @author Kang Yong
 * @date 2022/12/7
 * @since 1.0.0
 */
public class DebugFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("debug log:" + request);
    }
}
