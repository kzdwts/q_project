package top.kangyong.study02.design.pattern.structuralmode.adapter.object_adapter;

/**
 * 适配器类
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public class SDAdapterTF   implements SDCard {

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }

}
