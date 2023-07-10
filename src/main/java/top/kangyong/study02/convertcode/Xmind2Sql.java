package top.kangyong.study02.convertcode;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xmind 转换为 建表语句
 *
 * @author Kang Yong
 * @date 2023/7/10
 * @since 1.0.0
 */
public class Xmind2Sql {

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "E:\\code\\doit\\num04\\q_project\\q_project\\tmp01.txt";
        String sql = readAndConvert(sourceFilePath);
        System.out.println(sql);
    }

    public static String readAndConvert(String sourceFilePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        String tableName = "";

        List<String> lineStrs = Files.lines(Paths.get(sourceFilePath)).collect(Collectors.toList());
        for (String str : lineStrs) {
            if (str.contains("\t\t")) {
                // 想要拼接到上一行的备注上去
                sb.insert(sb.length() - 3, " " + str.trim() + ",");
                continue;
            }
            if (str.contains("\t")) {
//                `主键`                varchar(100) NOT NULL COMMENT '主键',
                sb.append("\t`").append(str.trim()).append("` varchar(100) NOT NULL COMMENT '").append(str.trim()).append("',").append("\n");
                continue;
            }
            if (!str.contains("\t")) {
                // 表名
                sb.append("CREATE TABLE `").append(str.trim()).append("` (").append("\n");
                tableName = str;
            }
//            if (StringUtils.isBlank(str.trim())) {
//
//            }
        }
        sb.append("\t`tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',\n");
        sb.append("\t`delete_flag` int(1) DEFAULT '0' COMMENT '删除标识 (0:正常，1:删除)',\n");
        sb.append("\t`create_user_uuid` varchar(50) DEFAULT NULL COMMENT '创建操作人',\n");
        sb.append("\t`create_time` datetime DEFAULT NULL COMMENT '创建时间',\n");
        sb.append("\t`modify_user_uuid` varchar(50) DEFAULT NULL COMMENT '修改操作人',\n");
        sb.append("\t`modify_time` datetime DEFAULT NULL COMMENT '修改时间',\n");
        sb.append("\t`modify_time` datetime DEFAULT NULL COMMENT '修改时间',\n");
        sb.append("\t`update_time` datetime DEFAULT NULL COMMENT '更新时间'\n");
        sb.append(") ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='").append(tableName).append("';\n\n");


        return sb.toString();
    }

}
