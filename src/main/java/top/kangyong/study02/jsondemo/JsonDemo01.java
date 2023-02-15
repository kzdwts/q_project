package top.kangyong.study02.jsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import sun.security.mscapi.CPublicKey;
import top.kangyong.study02.model.Car;
import top.kangyong.study02.model.Person;
import top.kangyong.study02.model.SmsSendDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    /**
     * 测试自然顺序，第一层参数是按首字母排序的
     */
    @Test
    public void natureJsonOrder() {
        Map<String, String> params = new HashMap<>();
        params.put("code", "888888");
        params.put("param1", "黄丽丽");
        params.put("param2", "马云");
        params.put("brand", "大众");

        SmsSendDTO dto = new SmsSendDTO();
        dto.setMobilePhoneNum("18225608251");
        dto.setTemplateUuid(UUID.randomUUID().toString());
        dto.setParam(params);
        dto.setName("九黎小康");

        for (int i = 0; i < 1000; i++) {
            String json = JSONObject.toJSONString(dto);
            System.out.println(json);
        }

    }

    @Test
    public void demoGetNullNode() {
        Car car = new Car();
        car.setType("MQB宝来");
        car.setColor("白色");
        car.setBrand("大众");
        car.setWeight(2000.59f);
        car.setPl("1.5L");
        car.setDriveMode("#92燃油");

        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(car));
        System.out.println(jsonObject.size());
        Object name = jsonObject.get("name");
        System.out.println(name);
        System.out.println(jsonObject.get("type"));

        Map cartMap = JSON.parseObject(JSON.toJSONString(car), Map.class);
        System.out.println(cartMap.size());
        String brand = (String) cartMap.getOrDefault("brand", null);
        System.out.println(brand);

        String mobile = (String) cartMap.getOrDefault("mobile", null);
        System.out.println(mobile);
    }

    @Test
    public void parseTest() {
        String s = "{\"customerName\":\"客户姓名\",\"customerPhone\":\"客户手机号\",\"busProjectName\":\"项目名称\",\"belongChannel\":\"所属渠道\",\"agentName\":\"经纪人名称\",\"agentPhone\":\"经纪人手机号\",\"filingUserName\":\"报备人姓名\",\"filingUserPhone\":\"报备人手机号\",\"filingTime\":\"报备时间\",\"visitTime\":\"到访时间\",\"customerGender\":\"客户性别\",\"teamName\":\"团队名称\",\"channelName\":\"小组名称\",\"protectedEndTime\":\"保护期截止时间\",\"consultantName\":\"顾问名称\",\"consultantPhone\":\"顾问手机号\"}";
        Map<String, String> map = JSON.parseObject(s, Map.class);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println((entry.getKey() + ": " + entry.getValue()));
        }
    }

    /**
     * 实体转map
     * map转实体
     *
     * @author Kang Yong
     * @date 2023/2/15
     */
    @Test
    public void parseObject() {
        Car car = new Car();
        car.setType("MQB宝来");
        car.setColor("白色");
        car.setBrand("大众");
        car.setWeight(2000.59f);
        car.setPl("1.5L");
        car.setDriveMode("#92燃油");

        Map<String, Object> cartMap = JSON.parseObject(JSON.toJSONString(car), Map.class);
        System.out.println("cartMap.size() = " + cartMap.size());
        for (Map.Entry<String, Object> entry : cartMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("===================");
        String jsonStr = JSON.toJSONString(cartMap);
        Car newCar = JSON.parseObject(jsonStr, Car.class);
        System.out.println("newCar = " + newCar);
    }

}
