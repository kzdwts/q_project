package top.kangyong.study02.jsondemo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.util.DigestUtils;
import top.kangyong.study02.model.Car;
import top.kangyong.study02.model.UserDTO;
import top.kangyong.study02.model.VehicleDTO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * json嵌套 问题
 *
 * @author Kang Yong
 * @date 2023/10/30
 * @since 1.0.0
 */
public class JsonDemo02 {

    /**
     * 测试嵌套的JSON字符串是否可以parse
     * <p>
     * 结论：可以parse
     */
    @Test
    public void testJsonParseMul() {
        // 对象转JSON字符串
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1001L);
        userDTO.setUserName("张佳乐");

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setName("雅迪");

        Car car = new Car();
        car.setBrand("雅迪");
        car.setColor("小黄鸭");
        car.setType("两个轮");
        car.setWeight(100F);
        car.setPl("1.5L");
        car.setDriveMode("纯电+人力");

        vehicleDTO.setCar(car);

        userDTO.setVehicleDTO(vehicleDTO);

        String jsonStr = JSON.toJSONString(userDTO);
        System.out.println("jsonStr = " + jsonStr);


        // 字符串转JSON
        UserDTO ud = JSON.parseObject(jsonStr, UserDTO.class);
        System.out.println("ud = " + ud);
        System.out.println("ud.getUserId() = " + ud.getUserId());
        System.out.println("ud.getUserName() = " + ud.getUserName());

        VehicleDTO vd = ud.getVehicleDTO();
        System.out.println("vd.getName() = " + vd.getName());

        Car c = vd.getCar();
        System.out.println("c.getBrand() = " + c.getBrand());
        System.out.println("c.getType() = " + c.getType());
        System.out.println("c.getPl() = " + c.getPl());
        System.out.println("c.getWeight() = " + c.getWeight());
        System.out.println("c.getColor() = " + c.getColor());
        System.out.println("c.getDriveMode() = " + c.getDriveMode());

    }

    @Test
    public void testJsonToBase64MD5() throws NoSuchAlgorithmException {
        Car car = new Car();
        car.setBrand("雅迪");
        car.setColor("小黄鸭");
        car.setType("两个轮");
        car.setWeight(100F);
        car.setPl("1.50L");
        car.setDriveMode("纯电+人力");


        String car1Json = JSON.toJSONString(car);

        // 获取MD5哈希算法实例
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] hashInBytes = md.digest(car1Json.getBytes(StandardCharsets.UTF_8));

        byte[] hashInBytes = DigestUtils.md5Digest(car1Json.getBytes());

        // 将MD5哈希值转换为Base64编码字符串
        String base64Hash = Base64.getEncoder().encodeToString(hashInBytes);
        System.out.println("base64Hash = " + base64Hash);
        // 4dxRQUbxIBZJXJs5wTSsNQ==
        // 4dxRQUbxIBZJXJs5wTSsNQ==
        // 4dxRQUbxIBZJXJs5wTSsNQ==

        // p+QWedewpb7zAPwPdnf5oQ==
        // p+QWedewpb7zAPwPdnf5oQ==

    }
}
