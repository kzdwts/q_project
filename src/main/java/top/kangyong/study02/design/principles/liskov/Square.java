package top.kangyong.study02.design.principles.liskov;

/**
 * 正方形
 * <p>
 * 里氏替换原则
 *
 * @author Kang Yong
 * @date 2022/6/28
 * @since 1.0.0
 */
public class Square extends Rectangle {

    @Override
    public void setLenght(Integer lenght) {
        super.setLenght(lenght);
        super.setWidth(lenght);
    }

    @Override
    public void setWidth(Integer width) {
        super.setLenght(width);
        super.setWidth(width);
    }
}
