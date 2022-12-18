package top.kangyong.study01.design.pattern.transfer_object;

/**
 * 传输对象模式
 *
 * @author Kang Yong
 * @date 2022/12/18
 * @since 1.0.0
 */
public class StudentVO {

    private String name;
    private int roolNo;

    public StudentVO(String name, int roolNo) {
        this.name = name;
        this.roolNo = roolNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoolNo() {
        return roolNo;
    }

    public void setRoolNo(int roolNo) {
        this.roolNo = roolNo;
    }
}
