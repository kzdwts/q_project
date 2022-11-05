package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        SDCard sdCard = new SDCardImpl();

        Computer computer = new Computer();

        String msg = computer.readSD(sdCard);
        System.out.println(msg);

        System.out.println("====================");
        // 适配器
        String msg2 = computer.readSD(new SDAdapterTF());
        System.out.println(msg2);

    }

}
