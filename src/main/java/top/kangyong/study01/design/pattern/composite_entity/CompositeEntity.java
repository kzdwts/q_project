package top.kangyong.study01.design.pattern.composite_entity;

/**
 * 组合实体
 * <p>
 * 组合实体模式
 *
 * @author Kang Yong
 * @date 2022/12/2
 * @since 1.0.0
 */
public class CompositeEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }

}
