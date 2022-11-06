package top.kangyong.study02.design.pattern.structuralmode.adapter.object_adapter;

import java.util.Objects;

/**
 * computer
 * <p>
 * 对象适配器
 *
 * @author Kang Yong
 * @date 2022/11/5
 * @since 1.0.0
 */
public class Computer {

    /**
     * 从sd卡读取数据
     *
     * @param sdCard {@link SDCard}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/11/5
     */
    public String readSD(SDCard sdCard) {
        if (Objects.isNull(sdCard)) {
            throw new NullPointerException("sd card can't null");
        }
        return sdCard.readSD();
    }
}
