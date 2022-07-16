package top.kangyong.study02.design.principles.dependency.after;

/**
 * 硬盘
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public interface HardDisk {

    /**
     * 保存数据
     *
     * @param data {@link String}
     * @author Kang Yong
     * @date 2022/7/16
     */
    void save(String data);

    /**
     * 读取数据
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/7/16
     */
    String get();
}
