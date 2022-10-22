package top.kangyong.study02.design.pattern.creatormode.builder.demo01;

/**
 * test
 * <p>
 * 创建者模式
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());

        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
