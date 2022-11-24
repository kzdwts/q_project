package top.kangyong.study02.design.pattern.structuralmode.flyweight;

/**
 * O 图形类（具体享元角色）
 * <p>
 * 享元模式
 *
 * @author Kang Yong
 * @date 2022/11/21
 * @since 1.0.0
 */
public class OBox extends AbstractBox {

    @Override
    public String getShape() {
        return "O";
    }

}
