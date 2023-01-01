package top.kangyong.study02.design.pattern.behaviormode.responsibility.jdk;

/**
 * jdk责任链模式
 *
 * @author Kang Yong
 * @date 2023/1/1
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Request req = null;
        Response res = null;

        FilterChain c = new FilterChain();
        c.FilterChain(new FirstFilter()).FilterChain(new SecondFilter());
        c.doFilter(req, res);
    }

}
