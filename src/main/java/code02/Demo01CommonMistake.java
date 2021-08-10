package code02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 常见是大错误集锦
 * @author: Kang Yong
 * @date: 2021/8/10 14:00
 * @version: v1.0
 */
public class Demo01CommonMistake {

    /**
     * 将一个数组转化为列表
     */
    @Test
    public void testArrayToList() {
        String[] nameArr = new String[]{"王丽丽", "储小姣", "李子木"};
        List<String> nameList = Arrays.asList(nameArr);
        /*
        这个操作会报错，因为上一步操作返回的ArrayList全称是java.util.Arrays.ArrayList，并不是java.util.ArrayList
         */
//        nameList.add("孙柯瑶");
        nameList.forEach(System.out::println);


        List<String> nameArrayList = new ArrayList<>(Arrays.asList(nameArr));
        nameArrayList.add("陆智航");
        nameArrayList.forEach(System.out::println);
    }

}
