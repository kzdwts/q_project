package top.kangyong.study02.inherit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("小猫咪");
        cat.setAge(3);
        cat.setColor("奶奶灰");
        cat.setSkill("抓老鼠");

        String jsonStr = JSON.toJSONString(cat);
        Animal animal = JSON.parseObject(jsonStr, Animal.class);
        System.out.println(animal);


        // 子类继承父类，这里使用多态，打印出的仍然是子类的所有数据
        Animal cat1 = cat;
        System.out.println(JSON.toJSONString(cat1));

    }

}
