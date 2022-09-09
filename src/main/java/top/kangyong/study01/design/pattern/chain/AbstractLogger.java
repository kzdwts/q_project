package top.kangyong.study01.design.pattern.chain;

/**
 * 责任链模式
 * <p>
 * 行为型模式。
 *
 * @author Kang Yong
 * @date 2022/9/8
 * @since 1.0.0
 */
public abstract class AbstractLogger {

    private static int INFO = 1;
    private static int DEBUG = 2;
    private static int EROR = 3;

    protected int level;

    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}
