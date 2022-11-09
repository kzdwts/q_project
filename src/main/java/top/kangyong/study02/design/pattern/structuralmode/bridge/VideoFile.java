package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * 实现化角色
 * <p>
 * 桥接模式
 *
 * @author Kang Yong
 * @date 2022/11/9
 * @since 1.0.0
 */
public interface VideoFile {

    /**
     * 解码功能
     *
     * @param fileName {@link String}
     * @author Kang Yong
     * @date 2022/11/9
     */
    void decode(String fileName);
}
