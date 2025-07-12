package top.kangyong.study02.tree;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 属性处理
 *
 * @author Kang Yong
 * @date 2025/7/10
 * @since 1.0.0
 */
public class TreeDemo {

    @Test
    public void treeDemo() {
        NodeDTO n0 = new NodeDTO(1L, "张三丰");

        NodeDTO n11 = new NodeDTO(11L, "张翠三");
        NodeDTO n12 = new NodeDTO(12L, "俞岱岩");
        NodeDTO n13 = new NodeDTO(13L, "宋远桥");
        NodeDTO n14 = new NodeDTO(14L, "殷梨亭");
        NodeDTO n15 = new NodeDTO(15L, "莫七侠");

        NodeDTO n21 = new NodeDTO(21L, "张无忌");
        NodeDTO n22 = new NodeDTO(22L, "宋青书");
        NodeDTO n23 = new NodeDTO(23L, "宋废书");

        NodeDTO n31 = new NodeDTO(31L, "张风");
        NodeDTO n32 = new NodeDTO(32L, "张周");

        n21.setChildren(Arrays.asList(n31, n32));
        n11.setChildren(Collections.singletonList(n21));
        n13.setChildren(Arrays.asList(n22, n23));
        n0.setChildren(Arrays.asList(n11, n12, n13, n14, n15));

        // 修改：禁用循环引用检测
        System.out.println("JSON.toJSONString(n0) = " + JSON.toJSONString(n0, SerializerFeature.DisableCircularReferenceDetect));

        // 将所有数据打平
        List<NodeDTO> dfsDtoList = flattenTreeDfs(Collections.singletonList(n0));
        System.out.println("JSON.toJSONString(dfsDtoList) = " + JSON.toJSONString(dfsDtoList, SerializerFeature.DisableCircularReferenceDetect));

        List<NodeDTO> bfsDtoList = flattenTreeBfs(Collections.singletonList(n0));
        System.out.println("JSON.toJSONString(bfsDtoList) = " + JSON.toJSONString(bfsDtoList, SerializerFeature.DisableCircularReferenceDetect));

        // 示例：多字段过滤
        List<NodeDTO> filteredList = filterNodes(dfsDtoList,
                node -> node.getId() > 10 && node.getId() < 20,
                node -> node.getName().contains("张"));
        System.out.println("JSON.toJSONString(filteredList) = " + JSON.toJSONString(filteredList, SerializerFeature.DisableCircularReferenceDetect));
    }

    /**
     * BFS	Queue	广度优先
     *
     * @param rootNodes 根节点列表
     * @return 打平后的节点列表
     */
    public static List<NodeDTO> flattenTreeBfs(List<NodeDTO> rootNodes) {
        if (CollUtil.isEmpty(rootNodes)) {
            return Collections.emptyList();
        }

        List<NodeDTO> result = new ArrayList<>();
        Queue<NodeDTO> queue = new LinkedList<>(rootNodes);

        while (!queue.isEmpty()) {
            NodeDTO node = queue.poll();
            result.add(node);

            if (CollUtil.isNotEmpty(node.getChildren())) {
                queue.addAll(node.getChildren());
            }
        }

        return result;
    }

    /**
     * DFS	Stack	深度优先
     *
     * @param rootNodes 根节点列表
     * @return 打平后的节点列表
     */
    public static List<NodeDTO> flattenTreeDfs(List<NodeDTO> rootNodes) {
        if (CollUtil.isEmpty(rootNodes)) {
            return Collections.emptyList();
        }

        List<NodeDTO> result = new ArrayList<>();
        Stack<NodeDTO> stack = new Stack<>();
        stack.addAll(rootNodes);

        while (!stack.isEmpty()) {
            NodeDTO node = stack.pop();
            result.add(node);

            if (CollUtil.isNotEmpty(node.getChildren())) {
                // 反向添加子节点以保持正确的顺序
                List<NodeDTO> children = node.getChildren();
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }

        return result;
    }

    /**
     * 多字段过滤方法
     *
     * @param nodes     节点列表
     * @param predicates 多个过滤条件
     * @return 过滤后的节点列表
     */
    public static List<NodeDTO> filterNodes(List<NodeDTO> nodes, Predicate<NodeDTO>... predicates) {
        if (CollUtil.isEmpty(nodes) || predicates == null || predicates.length == 0) {
            return Collections.emptyList();
        }

        return Arrays.stream(predicates)
                .reduce(Predicate::and) // 将所有条件组合为一个 AND 条件
                .map(predicate -> nodes.stream().filter(predicate).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Test
    public void testSoutNull() {
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(2L);

        String desc = "id=%s,name=%s";
        String format = String.format(desc, nodeDTO.getId(), nodeDTO.getName());
        System.out.println("format = " + format);
    }
}