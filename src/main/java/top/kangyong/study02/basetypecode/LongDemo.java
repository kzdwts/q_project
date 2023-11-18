package top.kangyong.study02.basetypecode;

import org.junit.Test;

import java.util.concurrent.atomic.LongAdder;

/**
 * Long 测试
 *
 * @author Kang Yong
 * @date 2023/11/16
 * @since 1.0.0
 */
public class LongDemo {

    @Test
    public void longAdderTest1() {
        Integer printMulNum = 10000;

        int result = 1000000;
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < result; i++) {
            longAdder.increment();
            if (longAdder.longValue() % printMulNum == 0) {
                System.out.println("longAdder.longValue() = " + longAdder.longValue());
            }
        }

        System.out.println("OVER");
    }
}
