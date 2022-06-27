package top.kangyong.study01.design.pattern.prototype;

/**
 * 形状
 * <p>
 * 原型模式
 *
 * @author Kang Yong
 * @date 2022/6/25
 * @since 1.0.0
 */
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
