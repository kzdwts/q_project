package top.kangyong.study02.design.pattern.creatormode.builder.demo02;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板")
                .build();

        System.out.println(phone);
    }

}
