package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * 适配者类的接口
 * <p>
 * 适配器模式-类适配器
 *
 * @author Kang Yong
 * @date 2022/11/3
 * @since 1.0.0
 */
public interface TFCard {

    /**
     * 从TF卡读取数据
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/11/3
     */
    String readTF();

    /**
     * 往TF卡写数据
     *
     * @param msg {@link String}
     * @author Kang Yong
     * @date 2022/11/3
     */
    void writeTF(String msg);
}
