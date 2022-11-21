package top.kangyong.study02.design.pattern.structuralmode.flyweight;

/**
 * L 图形类（具体享元角色）
 *
 * @author Kang Yong
 * @date 2022/11/21
 * @since 1.0.0
 */
public class LBox extends AbstractBox {

    @Override
    public String getShape() {
        return "L";
    }

}
