package top.kangyong.study02.design.principles.dependency.before;

/**
 * 运行电脑
 * <p>
 * 依赖倒置原则
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public class ComputerDemo {

    public static void main(String[] args) {
        XiJieHardDisk hardDisk = new XiJieHardDisk();
        IntelCpu cpu = new IntelCpu();
        KingstonMemory memory = new KingstonMemory();

        Computer c = new Computer();

        c.setHardDisk(hardDisk);
        c.setCpu(cpu);
        c.setMemory(memory);

        c.run();
        ;

    }
}
