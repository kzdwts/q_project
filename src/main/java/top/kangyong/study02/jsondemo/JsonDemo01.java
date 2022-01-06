package top.kangyong.study02.jsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import top.kangyong.study02.model.Car;
import top.kangyong.study02.model.Person;

/**
 * json测试
 *
 * @author Kang Yong
 * @date 2022/1/6
 * @since 1.0.0
 */
public class JsonDemo01 {

    /**
     * 实体类转json，按照属性排序，方法一
     *
     * @author Kang Yong
     * @date 2022/1/6
     */
    @Test
    public void orderByAttributeTest01() {
        // 封装实体类
        Person person = new Person();
        person.setId(1);
        person.setAge(18);
        person.setName("王丽丽");
        person.setGender(0);
        person.setWeight(48.55f);

        String personJson = JSONObject.toJSONString(person);
        System.out.println(personJson);

        String personJson2 = JSON.toJSONString(person);
        System.out.println(personJson2);

        // 原始toJSONString
//        {"age":18,"gender":0,"id":1,"name":"王丽丽","weight":48.55}
//        {"age":18,"gender":0,"id":1,"name":"王丽丽","weight":48.55}

        // 第一种方法，在实体类加 @JSONType(orders = {"id", "name", "age", "gender", "weight"})
//        {"id":1,"name":"王丽丽","age":18,"gender":0,"weight":48.55}
//        {"id":1,"name":"王丽丽","age":18,"gender":0,"weight":48.55}
    }

    /**
     * 实体类转json，按照属性排序，方法二
     *
     * @author Kang Yong
     * @date 2022/1/6
     */
    @Test
    public void orderByAttributeTest02() {
        // 封装实体类
        Car car = new Car();
        car.setType("MQB宝来");
        car.setColor("白色");
        car.setBrand("大众");
        car.setWeight(2000.59f);
        car.setPl("1.5L");
        car.setDriveMode("#92燃油");

        String personJson = JSONObject.toJSONString(car);
        System.out.println(personJson);

        String personJson2 = JSON.toJSONString(car);
        System.out.println(personJson2);

        // 原始toJSONString
//        {"brand":"大众","color":"白色","driveMode":"#92燃油","pl":"1.5L","type":"MQB宝来","weight":2000.59}
//        {"brand":"大众","color":"白色","driveMode":"#92燃油","pl":"1.5L","type":"MQB宝来","weight":2000.59}

        // 第二种方法，在属性上添加 @JSONField(ordinal = 1)
//        {"brand":"大众","color":"白色","type":"MQB宝来","weight":2000.59,"pl":"1.5L","driveMode":"#92燃油"}
//        {"brand":"大众","color":"白色","type":"MQB宝来","weight":2000.59,"pl":"1.5L","driveMode":"#92燃油"}
    }

}
