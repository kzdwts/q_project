package top.kangyong.study02.design.pattern.creatormode.builder.demo02;

/**
 * 手机类
 * <p>
 * 创建者模式
 *
 * @author Kang Yong
 * @date 2022/10/23
 * @since 1.0.0
 */
public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    /**
     * 私有构造方法
     *
     * @param builder
     */
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        /**
         * 使用构建者创建phone对象
         *
         * @return {@link Phone}
         * @author Kang Yong
         * @date 2022/10/23
         */
        public Phone build() {
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }
}
