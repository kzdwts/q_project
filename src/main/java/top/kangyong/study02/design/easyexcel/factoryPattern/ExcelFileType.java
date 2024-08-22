package top.kangyong.study02.design.easyexcel.factoryPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 文件类型
 *
 * @author Kang Yong
 * @date 2024/8/22
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ExcelFileType {

    /**
     * xls
     */
    XLS(".xls"),
    /**
     * xlsx
     */
    XLSX(".xlsx");

    private String value;

}
