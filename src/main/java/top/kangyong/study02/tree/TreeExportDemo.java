package top.kangyong.study02.tree;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 树形结构导出
 *
 * @author Kang Yong
 * @date 2025/7/18
 * @since 1.0.0
 */
public class TreeExportDemo {

    @Test
    public void exportTree() {
        List<NodeDTO> nodeList = new ArrayList<>();
        // 武当派
        NodeDTO n0 = new NodeDTO(1L, "张三丰", 1);

        NodeDTO n11 = new NodeDTO(11L, "张翠三", 1);
        NodeDTO n12 = new NodeDTO(12L, "俞岱岩", 1);
        NodeDTO n13 = new NodeDTO(13L, "宋远桥", 1);
        NodeDTO n14 = new NodeDTO(14L, "殷梨亭", 1);
        NodeDTO n15 = new NodeDTO(15L, "莫七侠", 1);

        NodeDTO n21 = new NodeDTO(21L, "张无忌", 1);
        NodeDTO n22 = new NodeDTO(22L, "宋青书", 1);
        NodeDTO n23 = new NodeDTO(23L, "宋废书", 1);

        NodeDTO n31 = new NodeDTO(31L, "张风", 0);
        NodeDTO n32 = new NodeDTO(32L, "张周", 0);

        n21.setChildren(Arrays.asList(n31, n32));
        n11.setChildren(Collections.singletonList(n21));
        n13.setChildren(Arrays.asList(n22, n23));
        n0.setChildren(Arrays.asList(n11, n12, n13, n14, n15));

        // 华山派
        NodeDTO h0 = new NodeDTO(200L, "岳不群", 1);

        NodeDTO h11 = new NodeDTO(211L, "岳灵珊", 0);
        NodeDTO h12 = new NodeDTO(212L, "令狐冲", 1);

        h0.setChildren(Arrays.asList(h11, h12));

        nodeList.add(n0);
        nodeList.add(h0);

        System.out.println("JSON.toJSONString(nodeList) = " + JSON.toJSONString(nodeList));

        // 新增：导出树形结构到 Excel
        exportTreeToExcel(nodeList, "tree_export.xlsx");
    }

    /**
     * 将树形结构导出到 Excel
     *
     * @param nodeList 树形结构节点列表
     * @param filePath 导出文件路径
     */
    public void exportTreeToExcel(List<NodeDTO> nodeList, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Tree Structure");

        // 创建表头
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Level");

        // 递归写入数据
        int rowNum = 1;
        for (NodeDTO node : nodeList) {
            rowNum = writeNodeToExcel(sheet, node, rowNum, 0);
        }

        // 自动调整列宽
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // 写入文件
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            System.out.println("Excel 文件已生成：" + filePath);
        } catch (IOException e) {
            System.err.println("导出 Excel 失败：" + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.err.println("关闭工作簿失败：" + e.getMessage());
            }
        }
    }

    /**
     * 递归写入节点到 Excel
     *
     * @param sheet   工作表
     * @param node    当前节点
     * @param rowNum  当前行号
     * @param level   当前层级
     * @return 下一行号
     */
    private int writeNodeToExcel(Sheet sheet, NodeDTO node, int rowNum, int level) {
        Row row = sheet.createRow(rowNum++);
        Cell idCell = row.createCell(0);
        Cell nameCell = row.createCell(1);
        Cell levelCell = row.createCell(2);

        // 设置单元格值
        idCell.setCellValue(node.getId());
        
        // JDK 8 兼容实现：使用 StringBuilder 生成缩进
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level * 2; i++) {
            indent.append(" ");
        }
        nameCell.setCellValue(indent.toString() + node.getName());

        levelCell.setCellValue(level);

        // 递归写入子节点
        if (node.getChildren() != null) {
            for (NodeDTO child : node.getChildren()) {
                rowNum = writeNodeToExcel(sheet, child, rowNum, level + 1);
            }
        }

        return rowNum;
    }
}