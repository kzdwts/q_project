package top.kangyong.study02.design.easyexcel.factoryPattern;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
public class FactoryDemo {

    public static void main(String[] args) {
        ExcelReader reader = ReaderFactory.createReader(ExcelFileType.XLSX);
        reader.read();
    }

}
