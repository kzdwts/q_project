package top.kangyong.study01.design.pattern.bridge;

/**
 * 红色的园
 *
 * @author Kang Yong
 * @date 2022/7/14
 * @since 1.0.0
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x:" + x + ", y " + y + "]");
    }
}
