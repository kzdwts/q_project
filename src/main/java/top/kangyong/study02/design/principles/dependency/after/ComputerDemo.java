package top.kangyong.study02.design.principles.dependency.after;

/**
 * demo
 *
 * @author Kang Yong
 * @date 2022/7/17
 * @since 1.0.0
 */
public class ComputerDemo {

    public static void main(String[] args) {
        Cpu cpu = new IntelCpu();
        HardDisk hardDisk = new XiJieHardDisk();
        Memory memory = new KingstonMemory();

        Computer c = new Computer();
        c.setHardDisk(hardDisk);
        c.setCpu(cpu);
        c.setMemory(memory);

        c.run();
    }

}
