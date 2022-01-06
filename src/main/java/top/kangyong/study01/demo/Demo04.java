package top.kangyong.study01.demo;

import org.junit.Test;
import top.kangyong.study01.util.SplitUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 测试集合工具类分组方法
 * @author: kangyong
 * @date: 2019/7/4 14:49
 * @version: v1.0
 */
public class Demo04 {

    @Test
    public void test01Demo() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("姓名", "丽丽" + i);
            list.add(map);
        }

        // 分组
        List<List<Map<String, Object>>> resultList = SplitUtils.fixedGrouping(list, 2);
        System.out.println(resultList);


    }
}
