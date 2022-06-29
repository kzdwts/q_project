package top.kangyong.study02.design.principles.liskov.before;

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
    public void setLength(Integer lenght) {
        super.setLength(lenght);
        super.setWidth(lenght);
    }

    @Override
    public void setWidth(Integer width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
