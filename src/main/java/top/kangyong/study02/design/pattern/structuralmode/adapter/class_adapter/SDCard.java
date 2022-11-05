package top.kangyong.study02.design.pattern.structuralmode.adapter.class_adapter;

/**
 * 目标接口
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public interface SDCard {

    /**
     * 从sd读取数据
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/11/5
     */
    String readSD();

    /**
     * 向sd写数据
     *
     * @param msg {@link String} 数据
     * @author Kang Yong
     * @date 2022/11/5
     */
    void writeSD(String msg);

}
