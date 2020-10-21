package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: lambda表达式
 * @author: kangyong
 * @date: 2020/9/16 18:35
 * @version: v1.0
 */
public class LambdaDemo01 {

    /**
     * 遍历map
     */
    @Test
    public void testForeachMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王丽丽");
        map.put("age", 18);
        map.put("weight", 138.5f);
        map.put("color", "red");

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    /**
     * map转list
     */
    @Test
    public void testMapToList() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王丽丽");
        map.put("age", 18);
        map.put("weight", 138.5f);
        map.put("color", "red");
        map.put("height", 173.5f);

        // 转为list
        List<Object> vals = map.entrySet().stream().map(m -> {
            // return m.getValue();
            return m.getKey();
        }).collect(Collectors.toList());

        vals.forEach(System.out::println);
    }

    /**
     * list转map
     */
    @Test
    public void testListToMap() {
        List<Cart> list = new ArrayList<>();
        list.add(new Cart(1, "北京现代"));
        list.add(new Cart(2, "中国红旗"));
        list.add(new Cart(3, "本田"));
        list.add(new Cart(4, "福特野马", 5000f, "green"));
        list.add(new Cart(6, "大众宝来", 6000f, "white"));

        // 转为map
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Cart::getId, Cart::getBrand));
        map.forEach((k, v) -> System.out.println("id=" + k + " 品牌=" + v));

        System.out.println("===================");
        map.forEach((k, v) -> {
            System.out.println(k + v);
        });

        AtomicInteger num = new AtomicInteger();
        map.forEach((k, v) -> {
            num.addAndGet(k);
        });

        System.out.println("num= " + num.get());
    }


}
