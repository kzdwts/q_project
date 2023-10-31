package top.kangyong.study02.listcode;

import java.util.ArrayList;
import java.util.List;

/**
 * list 拆分
 *
 * @author Kang Yong
 * @date 2023/10/31
 * @since 1.0.0
 */
public class ListSplitter {

    public static void main(String[] args) {
        List<Object> originalList = createOriginalList(); // 你的原始 List

        List<List<Object>> subLists = splitList(originalList, 100);

        for (List<Object> subList : subLists) {
            // 在这里对每个子列表进行处理
            System.out.println(subList);
        }
    }

    // 创建一个包含 10 万条数据的示例原始 List
    private static List<Object> createOriginalList() {
        List<Object> originalList = new ArrayList<>();
        for (int i = 1; i <= 10008; i++) {
            originalList.add(i);
        }
        return originalList;
    }

    // 将一个 List 拆分成多个子列表，每个子列表的大小为 batchSize
    public static <T> List<List<T>> splitList(List<T> list, int batchSize) {
        List<List<T>> subLists = new ArrayList<>();

        for (int i = 0; i < list.size(); i += batchSize) {
            int end = Math.min(i + batchSize, list.size());
            subLists.add(list.subList(i, end));
        }

        return subLists;
    }

}
