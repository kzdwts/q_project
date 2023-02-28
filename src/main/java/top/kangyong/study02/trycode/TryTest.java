package top.kangyong.study02.trycode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * try catch finally
 *
 * @author Kang Yong
 * @date 2023/2/28
 * @since 1.0.0
 */
public class TryTest {

    @Test
    public void tryWithNoCatchAndFinally() {
        List<String> nameList = new ArrayList<>();

        try {
            // 正常业务
            nameList.add("刘婷");
            nameList.add("eason");

            // 抛个异常
            int n = 3 / 0;
        }
//        catch (Exception e) {
////            e.printStackTrace();
//            System.out.println("e.getMessage() = " + e.getMessage());
//        }
        finally {
            System.out.println("nameList.size() = " + nameList.size());
        }

        System.out.println("GAME OVER!");
        System.out.println("验证：try必须要有catch才行");
    }
}
