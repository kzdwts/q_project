package top.kangyong.study02.utilscode;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.util.Comparator;
import java.util.Objects;

/**
 * Objects测试
 *
 * @author Kang Yong
 * @date 2022/3/28
 * @since 1.0.0
 */
public class ObjectsTest {

    /**
     * 返回0，如果参数都是相同的， c.compare(a, b)其他。
     *
     * @author Kang Yong
     * @date 2022/3/28
     */
    @Test
    public void compareTestDemo() {
        String a = "123";
        String b = "123";
        int result = Objects.compare(a, b, Comparator.naturalOrder());
        System.out.println(result); // 0

        String c = "123";
        String d = "1235";
        result = Objects.compare(c, d, Comparator.naturalOrder());
        System.out.println(result); // -1

        String e = "null";
        String f = "null";
        result = Objects.compare(e, f, String::compareTo);
        System.out.println(result); // 0
    }

    /**
     * 检查指定的对象引用不是null 。该方法主要用于在方法和构造函数中进行参数验证
     * <p>
     * 说人话就是：
     * 下次再遇到要判断对象是否为空，空的时候报空指针异常的时候就可以使用这个方法
     *
     * @author Kang Yong
     * @date 2022/3/28
     */
    @Test
    public void requireNonNullTestDemo() {
//        Object result = Objects.requireNonNull(null);
//        System.out.println(result);

        Person person = Objects.requireNonNull(null, "bar must not be null");
        System.out.println(person);
    }

    /**
     * 如果为空就返回true
     *
     * @author Kang Yong
     * @date 2022/3/28
     */
    @Test
    public void isNullTestDemo() {
        boolean aNull = Objects.isNull(new Person());
        System.out.println(aNull); // false

        boolean aNull2 = Objects.isNull(null);
        System.out.println(aNull2); // true
    }

    /**
     * 如果不为空 返回true
     *
     * @author Kang Yong
     * @date 2022/3/28
     */
    @Test
    public void nonNullTestDemo() {
        boolean aNull = Objects.nonNull(new Person());
        System.out.println(aNull); // true

        boolean aNull2 = Objects.nonNull(null);
        System.out.println(aNull2); // false
    }

    /**
     * 测试toString
     *
     * @author Kang Yong
     * @date 2022/3/28
     */
    @Test
    public void toStringTestDemo() {
        String str1 = Objects.toString(new Person());
        System.out.println(str1);

        // 如果第一个参数不是 null ，则返回第一个参数调用 toString的结果， 否则toString返回第二个参数。
        String str2 = Objects.toString(null, "wanglili");
        System.out.println(str2);

        // 如果是null就返回“null”字符串
        String str3 = Objects.toString(null);
        System.out.println(str3);
    }
}
