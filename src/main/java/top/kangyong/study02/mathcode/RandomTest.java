package top.kangyong.study02.mathcode;

import org.junit.Test;

import java.util.Random;

/**
 * 随机
 *
 * @author Kang Yong
 * @date 2023/4/4
 * @since 1.0.0
 */
public class RandomTest {

    @Test
    public void genRandomTest() {
        for (int i = 1; i < 100000; i++) {
            System.out.println(getFormatNum(i));
        }
    }

    public static String getFormatNum(Integer id) {
        String str = String.format("%03d", id) + genRandomNum();
        return str;
    }

    public static Integer genRandomNum() {
        Random random = new Random();
        int i = random.nextInt(900) + 100;
        return new Integer(i);
    }
}
