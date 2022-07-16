package top.kangyong.study02.design.principles.dependency.before;

/**
 * 组装电脑
 * <p>
 * 依赖倒置原则
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public class Computer {

    private XiJieHardDisk hardDisk;
    private IntelCpu cpu;
    private KingstonMemory memory;

    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public IntelCpu getCpu() {
        return cpu;
    }

    public void setCpu(IntelCpu cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    /**
     * 电脑开机运行
     *
     * @author Kang Yong
     * @date 2022/7/16
     */
    public void run() {
        System.out.println("计算机开始运行");
        String data = hardDisk.get();
        System.out.println("从希捷硬盘读取的数据为：" + data);

        cpu.run();

        memory.save();
    }
}
