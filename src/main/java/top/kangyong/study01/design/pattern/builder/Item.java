package top.kangyong.study01.design.pattern.builder;

/**
 * 创建一个表示食物条目和食物包装的接口
 * <p>
 * 建造者模式
 */
public interface Item {

    String name();

    Packing packing();

    float price();
}
