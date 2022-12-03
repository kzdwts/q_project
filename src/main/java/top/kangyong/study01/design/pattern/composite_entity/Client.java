package top.kangyong.study01.design.pattern.composite_entity;

/**
 * 组合实体的客户端类
 * <p>
 * 组合实体模式
 *
 * @author Kang Yong
 * @date 2022/12/2
 * @since 1.0.0
 */
public class Client {

    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printData() {
        for (int i = 0; i < compositeEntity.getData().length; i++) {
            System.out.println("Data: " + compositeEntity.getData()[i]);
        }
    }

    public void setData(String data1, String data2) {
        compositeEntity.setData(data1, data2);
    }

}
