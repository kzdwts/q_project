package top.kangyong.study02.design.pattern.structuralmode.flyweight;

import java.util.HashMap;

/**
 * 工厂类，单例
 * <p>
 * 享元模式
 *
 * @author Kang Yong
 * @date 2022/11/21
 * @since 1.0.0
 */
public class BoxFactory {

    private HashMap<String, AbstractBox> map;

    /**
     * 私有化
     */
    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    public static BoxFactory getInstance() {
        return factory;
    }

    private static BoxFactory factory = new BoxFactory();

    /**
     * 获取形状
     *
     * @param name {@link String}
     * @return {@link AbstractBox}
     * @author Kang Yong
     * @date 2022/11/21
     */
    public AbstractBox getShape(String name) {
        return map.get(name);
    }
}
