package top.kangyong.study02.design.easyexcel.factoryPattern;

/**
 * Excel Reader 工厂
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
public class ReaderFactory {

    public static ExcelReader createReader(ExcelFileType fileType) {
        if (fileType == ExcelFileType.XLSX) {
            return new ExcelXlsxReader();
        } else if (fileType.equals(ExcelFileType.XLS)) {
            return new ExcelXlsReader();
        }
        throw new IllegalArgumentException("不支持的文件类型");
    }

}
