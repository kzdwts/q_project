package top.kangyong.study02.design.easyexcel.factoryPattern;

/**
 * Excel Xlsx 读取
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
public class ExcelXlsxReader implements ExcelReader {
    @Override
    public void read() {
        System.out.println("读取.xlsx文件");
    }
}
