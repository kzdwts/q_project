package top.kangyong.study02.design.easyexcel.builderPattern;

import top.kangyong.study02.design.easyexcel.factoryPattern.ExcelFileType;

/**
 * ExcelWriter
 * <p>
 * 建造者模式（Builder Pattern）
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
public class ExcelWriter {

    private String path;
    private ExcelFileType fileType;

    public ExcelWriter(String path, ExcelFileType fileType) {
        this.path = path;
        this.fileType = fileType;

        System.out.println("ExcelWriter 构造方法");
    }

    public void write() {
        System.out.println("ExcelWriter write 方法");
    }
}
