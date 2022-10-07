package top.kangyong.study02.design.pattern.creatormode.factory.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 咖啡工厂
 *
 * @author Kang Yong
 * @date 2022/10/7
 * @since 1.0.0
 */
public class CoffeeFactory {

    // 加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    // 1、定义容器对象存储咖啡对象
    private static Map<String, Coffee> map = new HashMap<>();

    // 2、加载配置文件，只加载一次
    static {
        Properties p = new Properties();

        try {
            InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            p.load(is);

            // 从p集合中获取全类名，并创建对象
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String className = p.getProperty((String) key);
                // 通过反射技术创建对象
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 生产咖啡
     *
     * @param name {@link String}
     * @return {@link Coffee}
     * @author Kang Yong
     * @date 2022/10/7
     */
    public static Coffee createCoffee(String name) {
        return map.getOrDefault(name, null);
    }

}
