package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * 适配器类
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public class SDAdapterTF  extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return super.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        super.writeTF(msg);
    }

}
