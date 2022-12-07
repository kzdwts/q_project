package top.kangyong.study01.design.pattern.intercepting_filter;

/**
 * target
 *
 * @author Kang Yong
 * @date 2022/12/7
 * @since 1.0.0
 */
public class Target {

    public void execute(String request) {
        System.out.println("executing target:" + request);
    }

}
