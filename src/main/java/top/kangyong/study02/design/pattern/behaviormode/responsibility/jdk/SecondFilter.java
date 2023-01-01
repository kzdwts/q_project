package top.kangyong.study02.design.pattern.behaviormode.responsibility.jdk;

/**
 * jdk责任链模式
 *
 * @author Kang Yong
 * @date 2023/1/1
 * @since 1.0.0
 */
public class SecondFilter implements Filter {

    @Override
    public void doFilter(Request req, Response res, FilterChain c) {
        System.out.println("过滤器2 前置执行");

        c.doFilter(req, res);

        System.out.println("过滤器2 后置执行");
    }

}
