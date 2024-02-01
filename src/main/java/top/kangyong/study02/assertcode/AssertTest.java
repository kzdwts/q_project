package top.kangyong.study02.assertcode;

import cn.hutool.core.lang.Assert;
import org.junit.Test;

/**
 * Assert
 *
 * @author Kang Yong
 * @date 2024/1/31
 * @since 1.0.0
 */
public class AssertTest {

    @Test
    public void testIsTrue() {
        String name1 = "哆啦A梦";
        String name2 = "叮当猫";

        Assert.isTrue(name1.equals(name2), "姓名不一致");
        System.out.println("==============");

        Assert.isFalse(name1.equals(name2));
        System.out.println("==============");

    }
}
