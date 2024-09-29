package top.kangyong.study02.mvel;

import org.junit.Test;
import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/9/29
 * @since 1.0.0
 */
public class MvelDemo1 {

    @Test
    public void simpleTest() {
        String expression = "name == 'zhangsan' && age == 18";

        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 18);

        Object eval = MVEL.eval(expression, map);
        System.out.println("eval = " + eval);

    }

    @Test
    public void addTest() {
        String expression = "1 + 2 + 3 + 4";
        Object eval = MVEL.eval(expression);
        System.out.println("eval = " + eval);
    }

}
