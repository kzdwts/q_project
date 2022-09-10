package top.kangyong.study01.design.pattern.chain;

/**
 * 责任链模式
 *
 * @author Kang Yong
 * @date 2022/9/10
 * @since 1.0.0
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
