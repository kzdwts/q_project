package top.kangyong.study02.design.principles.dependency.after;

/**
 * intel cpu
 * <p>
 * 依赖倒置原则
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public class IntelCpu implements Cpu {

    /**
     * cpu运行
     *
     * @author Kang Yong
     * @date 2022/7/16
     */
    @Override
    public void run() {
        System.out.println("Intel cpu 在运行...");
    }
}
