package top.kangyong.study01.design.pattern.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 工厂模式 shape工厂
 * @author: kangyong
 * @date: 2020/10/30 15:58
 * @version: v1.0
 */
public class ShapeFactory {

    /**
     * 获取对象实例
     *
     * @param shapeType
     * @return
     */
    public Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        }

        if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        } else if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        }

        return null;
    }

}
