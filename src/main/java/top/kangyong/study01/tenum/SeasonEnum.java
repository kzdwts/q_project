package top.kangyong.study01.tenum;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/11/29 18:00
 * @version: v1.0
 */
public enum SeasonEnum {

    SPRING(1),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);

    private int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

}
