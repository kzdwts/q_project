package top.kangyong.study02.enumcode;

import org.junit.Test;

/**
 *test
 *
 * @author Kang Yong
 * @date 2022/8/2
 * @since 1.0.0
 */
public class EnumPrintTest {

    @Test
    public void test01() {
        String desc = WarnTypeEnum.AUTUMN.getDesc();
        System.out.println("===");
        System.out.println(desc);
        System.out.println("===");
    }
}
