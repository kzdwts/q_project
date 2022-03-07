package top.kangyong.study02.uuiddemo;

import org.junit.Test;

import java.util.UUID;

/**
 * uuid测试
 *
 * @author Kang Yong
 * @date 2022/3/7
 * @since 1.0.0
 */
public class UUIDTest {

    /**
     * 生成uuid
     *
     * @author Kang Yong
     * @date 2022/3/7
     */
    @Test
    public void demo01() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }
}
