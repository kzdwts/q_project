package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 集合工具类
 * @author: kangyong
 * @date: 2019/7/4 14:31
 * @version: v1.0
 */
public class SplitUtils {

    /**
     * 将list分组，n个元素为一组
     *
     * @param sourceList 集合数据
     * @param n          分组个数
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> fixedGrouping(List<T> sourceList, int n) {
        // 如果为空，或分组小于等于0，直接返回
        if (null == sourceList || sourceList.isEmpty() || n <= 0) {
            return null;
        }

        // 存储结果
        List<List<T>> resultList = new ArrayList<>();
        // 获取数据源长度
        int sourceSize = sourceList.size();
        // 分为size组
        int size = (sourceSize / n) + 1;

        // 分组
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(sourceList.get(j));
                }
            }
            resultList.add(subset);
        }

        return resultList;
    }

}
