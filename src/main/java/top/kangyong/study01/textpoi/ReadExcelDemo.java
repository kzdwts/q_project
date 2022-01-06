package top.kangyong.study01.textpoi;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 读取Exceldemo
 * @author: kangyong
 * @date: 2019/6/25 15:26
 * @version: v1.0
 */
public class ReadExcelDemo {

    public static void main(String[] args) {
        // 测试1
//        readExcel01();
        readExcel02();

    }


    public static String readExcel02() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // 创建文件流对象
            File excelFile = new File("E:\\text.xlsx");
            // 创建文件流
            FileInputStream fis = new FileInputStream(excelFile);
            // 创建工作簿对象
            Workbook workbook = WorkbookFactory.create(fis);
            // 获取表格sheet的数量
            int sheetCount = workbook.getNumberOfSheets();

            // 遍历每个sheet
            for (int i = 0; i < sheetCount; i++) {
                // 获取第一个sheet对象
                Sheet sheet = workbook.getSheetAt(i);
                // 获取当前sheet总行数
                int rowCount = sheet.getPhysicalNumberOfRows();
                // 输出基本信息
                System.out.println("第" + i + "个工作簿，共有" + rowCount + "条数据");

                // 遍历每一行
                for (int j = 0; j < rowCount; j++) {
                    // 获取当前行对象
                    Row row = sheet.getRow(j);
                    // 获取总列数
                    int cellCount = row.getPhysicalNumberOfCells();
                    System.out.print(j + "\t");
                    String cell = String.valueOf(row.getCell(0));
                    row.getCell(1);
                    System.out.println(row.getCell(0) + "\t" + row.getCell(1) + "\t" + row.getCell(2) + "\t" + row.getCell(3));
                    System.out.println("---------------" + row.getCell(4));
                    String cell4 = String.valueOf(row.getCell(4));
                    System.out.println(cell4);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 读取excel
     *
     * @return
     */
    public static String readExcel01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // 创建文件流对象
            File excelFile = new File("E:\\text.xlsx");
            // 创建文件流
            FileInputStream fis = new FileInputStream(excelFile);
            // 创建工作簿对象
            Workbook workbook = WorkbookFactory.create(fis);
            // 获取表格sheet的数量
            int sheetCount = workbook.getNumberOfSheets();

            // 遍历每个sheet
            for (int i = 0; i < sheetCount; i++) {
                // 获取第一个sheet对象
                Sheet sheet = workbook.getSheetAt(i);
                // 获取当前sheet总行数
                int rowCount = sheet.getPhysicalNumberOfRows();
                // 输出基本信息
                System.out.println("第" + i + "个工作簿，共有" + rowCount + "条数据");

                // 遍历每一行
                for (int j = 0; j < rowCount; j++) {
                    // 获取当前行对象
                    Row row = sheet.getRow(j);
                    // 获取总列数
                    int cellCount = row.getPhysicalNumberOfCells();
                    System.out.print(j + "\t");
                    // 遍历每一列
                    for (int k = 0; k < cellCount; k++) {
                        // 获取当前列
                        Cell cell = row.getCell(k);
                        int cellType = cell.getCellType();
                        String cellValue = null;
                        switch (cellType) {
                            case Cell.CELL_TYPE_STRING:
                                // 文本
                                cellValue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                // 日期型
                                cellValue = sdf.format(cell.getDateCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                // 布尔
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                // 空白
                                cellValue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                // 错误
                                cellValue = "错误";
                                break;

                            default:
                                cellValue = "错误";
                        }
                        System.out.print(cellValue + "    ");
                    }
                    System.out.println();
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}
