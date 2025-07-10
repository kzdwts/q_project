package top.kangyong.study02.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 递归
 *
 * @author Kang Yong
 * @date 2025/7/10
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class NodeDTO implements Serializable {

    private Long id;
    private String name;

    private List<NodeDTO> children;

    public NodeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
