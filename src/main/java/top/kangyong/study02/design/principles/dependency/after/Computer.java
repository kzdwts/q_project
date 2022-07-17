package top.kangyong.study02.design.principles.dependency.after;

/**
 * 组装电脑
 *
 * @author Kang Yong
 * @date 2022/7/17
 * @since 1.0.0
 */
public class Computer {

    private HardDisk hardDisk;

    private Cpu cpu;

    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void run() {
        System.out.println("计算机开始运行");
        String data = hardDisk.get();
        System.out.println("从希捷硬盘读取的数据为：" + data);

        cpu.run();

        memory.save();
    }
}
