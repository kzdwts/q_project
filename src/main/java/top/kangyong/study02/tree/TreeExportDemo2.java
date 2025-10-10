package top.kangyong.study02.tree;

import com.alibaba.fastjson.JSON;
import com.alibaba.excel.EasyExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
public class TreeExportDemo2 {

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

        // 调用导出方法
        exportTreeToExcel(nodeList, "tree_export.xlsx");
    }

    /**
     * 将树形结构导出到 Excel
     *
     * @param nodeList 树形结构节点列表
     * @param fileName 导出的文件名
     */
    private void exportTreeToExcel(List<NodeDTO> nodeList, String fileName) {
        // 使用 EasyExcel 写入 Excel
        EasyExcel.write(fileName, NodeDTO.class)
                .sheet("树形结构")
                .doWrite(() -> {
                    List<NodeDTO> flatList = new ArrayList<>();
                    flattenTree(nodeList, flatList, 0);
                    return flatList;
                });
    }

    /**
     * 递归展平树形结构
     *
     * @param nodeList   当前节点列表
     * @param flatList   展平后的节点列表
     * @param level      当前层级
     */
    private void flattenTree(List<NodeDTO> nodeList, List<NodeDTO> flatList, int level) {
        for (NodeDTO node : nodeList) {
            node.setLevel(level); // 设置层级
            flatList.add(node);
            if (node.getChildren() != null && !node.getChildren().isEmpty()) {
                flattenTree(node.getChildren(), flatList, level + 1);
            }
        }
    }
}