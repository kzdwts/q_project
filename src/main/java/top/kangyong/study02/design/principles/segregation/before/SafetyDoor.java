package top.kangyong.study02.design.principles.segregation.before;

/**
 * 安全门
 *
 * @author Kang Yong
 * @date 2022/7/19
 * @since 1.0.0
 */
public interface SafetyDoor {

    /**
     * 防盗
     *
     * @author Kang Yong
     * @date 2022/7/19
     */
    void antiTheft();

    /**
     * 防火
     *
     * @author Kang Yong
     * @date 2022/7/19
     */
    void fireProof();

    /**
     * 防水
     *
     * @author Kang Yong
     * @date 2022/7/19
     */
    void waterProof();
}
