package top.kangyong.study01.design.pattern.composite_entity;

/**
 * 粗粒对象
 * <p>
 * 组合实体模式
 *
 * @author Kang Yong
 * @date 2022/12/2
 * @since 1.0.0
 */
public class CoarseGrainedObject {

    private DependentObject1 object1 = new DependentObject1();
    private DependentObject2 object2 = new DependentObject2();

    public void setData(String data1, String data2) {
        this.object1.setData(data1);
        this.object2.setData(data2);
    }

    public String[] getData() {
        return new String[]{object1.getData(), object2.getData()};
    }

}
