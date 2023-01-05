package top.kangyong.study02.enumcode;

import org.junit.Test;

import java.util.Optional;

/**
 * 枚举遍历测试
 *
 * @author Kang Yong
 * @date 2023/1/5
 * @since 1.0.0
 */
public class TaskStatusCodeEnumTest {

    @Test
    public void testForeach() {
        for (TaskStatusCodeEnum value : TaskStatusCodeEnum.values()) {
            System.out.println("code = " + value.getCode() + " desc = " + value.getDesc());
        }

    }
}
