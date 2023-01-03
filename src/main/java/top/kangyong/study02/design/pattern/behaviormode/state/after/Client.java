package top.kangyong.study02.design.pattern.behaviormode.state.after;

/**
 * 状态模式
 *
 * 优点：
 * 将所有与某个状态有关的行为放到一个类中，并且可以方便的增加新的状态，只需要改变对象状态即可改变对象的行为
 * 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块
 *
 * 缺点：
 * 状态模式的使用必然会增加系统类和对象的个数
 * 状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱
 * 状态模式对“开闭原则”的支持并不太好
 *
 * 使用场景：
 * 当一个对象的行为取决于它的状态，并且他必须在运行时根据状态改变行为时，可以考虑使用状态模式
 * 一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态
 *
 * @author Kang Yong
 * @date 2023/1/2
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new RunningState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }

}
