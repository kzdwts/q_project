package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * 具体的sd卡类
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        String msg = "SDCard read msg: hello world SD";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg: " + msg);
    }
}
