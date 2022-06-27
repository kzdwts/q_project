package top.kangyong.study01.design.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kang Yong
 * @date 2022/6/27
 * @since 1.0.0
 */
public class ShapeCache {


    private static Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        Shape chchedShape = shapeMap.get(shapeId);

        return (Shape) chchedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
