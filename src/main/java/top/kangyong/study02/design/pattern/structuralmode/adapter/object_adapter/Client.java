package top.kangyong.study02.design.pattern.structuralmode.adapter.object_adapter;

/**
 * test
 * <p>
 * 对象适配器
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


    }

}
