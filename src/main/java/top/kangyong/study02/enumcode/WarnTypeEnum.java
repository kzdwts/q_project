package top.kangyong.study02.enumcode;

import lombok.Getter;

/**
 * 枚举
 *
 * @author Kang Yong
 * @date 2022/8/2
 * @since 1.0.0
 */
@Getter
public enum WarnTypeEnum {

    SPRING("1"),
    SUMMER("2"),
    AUTUMN("3"),
    WINTER("4");

    private String desc;

    WarnTypeEnum(String desc) {
        this.desc = desc;
    }

    public static String getDesc(WarnTypeEnum typeEnum) {
        return typeEnum.desc;
    }

}
