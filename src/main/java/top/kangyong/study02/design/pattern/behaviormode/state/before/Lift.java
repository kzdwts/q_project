package top.kangyong.study02.design.pattern.behaviormode.state.before;

import java.io.Serializable;

/**
 * 电梯类（子实现类）
 * <p>
 * 状态模式
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class Lift implements ILift {

    // 电梯状态
    int state;

    /**
     * 设置状态
     *
     * @param state {@link Integer}
     * @author Kang Yong
     * @date 2023/1/2
     */
    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public void open() {
        switch (state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯门已开启...");
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                System.out.println("电梯门已开启...");
                this.setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("电梯门已关闭...");
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯开始运行了...");
                this.setState(RUNNING_STATE);//现在是运行状态
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                System.out.println("电梯开始运行了...");
                this.setState(RUNNING_STATE);//现在是运行状态
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯停止了...");
                this.setState(STOPPING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("电梯停止了...");
                this.setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                break;
        }
    }
}
