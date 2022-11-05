package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * 适配器模式-类适配器
 *
 * @author Kang Yong
 * @date 2022/11/3
 * @since 1.0.0
 */
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        String msg = "TFCard read msg: hello world TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg: " + msg);
    }
}
