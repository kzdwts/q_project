package top.kangyong.study01.design.pattern.chain;

/**
 * 责任链模式
 * <p>
 * 行为型模式。
 *
 * @author Kang Yong
 * @date 2022/9/9
 * @since 1.0.0
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console Logger: " + message);
    }

}
