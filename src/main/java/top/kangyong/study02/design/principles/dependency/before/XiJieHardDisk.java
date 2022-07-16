package top.kangyong.study02.design.principles.dependency.before;

/**
 * 希捷硬盘
 *
 * @author Kang Yong
 * @date 2022/7/16
 * @since 1.0.0
 */
public class XiJieHardDisk {

    /**
     * 存储数据
     *
     * @param data {@link String}
     * @author Kang Yong
     * @date 2022/7/16
     */
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据：" + data);
    }

    /**
     * 读数据
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/7/16
     */
    public String get() {
        System.out.println("读取希捷硬盘数据");
        return "数据";
    }

}
