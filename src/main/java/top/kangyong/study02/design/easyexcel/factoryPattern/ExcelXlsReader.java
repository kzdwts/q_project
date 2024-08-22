package top.kangyong.study02.design.easyexcel.factoryPattern;

/**
 * Excel xls 读取
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
public class ExcelXlsReader implements ExcelReader {
    @Override
    public void read() {
        System.out.println("读取.xls文件");
    }

}
