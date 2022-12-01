package top.kangyong.study02.design.pattern.behaviormode.strategy.two;

import java.util.Arrays;
import java.util.List;

/**
 * 组合（环境类）
 *
 * @author Kang Yong
 * @date 2022/12/1
 * @since 1.0.0
 */
public class StrategyProcessorComposite implements StrategyProcessor {

    private List<StrategyProcessor> list = Arrays.asList(new AStrategyProcessor(), new BStrategyProcessor(), new CStrategyProcessor());

    @Override
    public boolean support(String abc) {
        return false;
    }

    @Override
    public void show(String abc) {
        // 根据参数寻找一个可执行的具体实现类
        list.stream().filter(p -> p.support(abc)).findAny()
                .orElseThrow(() -> new UnsupportedOperationException("[尚未有具体实现]根据参数未找到适配业务场景"))
                .show(abc);
    }
}
