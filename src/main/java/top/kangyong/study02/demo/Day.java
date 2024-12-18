package top.kangyong.study02.demo;

/**
 * TODO description .
 *
 * @author Kang Yong
 * @date 2024/12/18
 * @since 1.0.0
 */
public class Day {
    private final int nian;
    private final int yue;
    private final int ri;
    private final int status;

    public Day(int nian, int yue, int ri, int status) {
        this.nian = nian;
        this.yue = yue;
        this.ri = ri;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Day(" + nian + "," + yue + "," + ri + "," + status + ")";
    }
}