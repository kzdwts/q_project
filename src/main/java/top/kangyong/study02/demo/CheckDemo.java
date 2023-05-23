package top.kangyong.study02.demo;

import org.junit.Test;
import top.kangyong.study02.model.Person;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * check demo
 *
 * @author Kang Yong
 * @date 2023/5/22
 * @since 1.0.0
 */
public class CheckDemo {

    /**
     * 比较对象的属性是否相等，null，空值
     *
     * @author Kang Yong
     * @date 2023/5/22
     */
    @Test
    public void checkEquals() {
        Person p1 = new Person();
        p1.setName("小蝴蝶");
        p1.setAge(28);
        p1.setNationality("");

        Person p2 = new Person();
        p2.setGender(1);
        p2.setAge(28);
        p2.setMoney(new BigDecimal(18));

        System.out.println("Objects.equals(p1.getId(), equals(p2.getId())) = " + Objects.equals(p1.getId(), equals(p2.getId())));
        System.out.println("Objects.equals(p1.getGender(), p2.getGender()) = " + Objects.equals(p1.getGender(), p2.getGender()));
        System.out.println("Objects.equals(p1.getAge(), p2.getAge()) = " + Objects.equals(p1.getAge(), p2.getAge()));
        System.out.println("Objects.equals(p1.getWeight(), p2.getWeight()) = " + Objects.equals(p1.getWeight(), p2.getWeight()));
        System.out.println("Objects.equals(p1.getName(), p2.getName()) = " + Objects.equals(p1.getName(), p2.getName()));
        System.out.println("Objects.equals(p1.getNationality(), p2.getNationality()) = " + Objects.equals(p1.getNationality(), p2.getNationality()));


//  校验失败 java.lang.NullPointerException
//        if (p1.getName().equals(p2.getName())) {
//            System.out.println("name success");
//        }
    }
}
