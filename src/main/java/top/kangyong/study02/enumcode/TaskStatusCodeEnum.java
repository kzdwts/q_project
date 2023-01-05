package top.kangyong.study02.enumcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1203510 ~ 1203512
 * 任务状态code
 * 1203511：未完成
 * 1203512：已完成
 *
 * @author Kang Yong
 * @date 2022/12/30
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TaskStatusCodeEnum {

    /**
     * 1203510：全部
     */
    ALL(1203510, "全部"),

    /**
     * 1203511：未完成
     */
    UNCOMPLETED(1203511, "未完成"),

    /**
     * 1203512：已完成
     */
    COMPLETED(1203512, "已完成"),

    ;

    private Integer code;

    private String desc;

    /**
     * 枚举转成Map.
     */
    private static final Map<Integer, TaskStatusCodeEnum> map = Arrays.stream(values()).collect(Collectors.toMap(TaskStatusCodeEnum::getCode, Function.identity()));

    /**
     * 功能: 根据Code获取描述信息.
     *
     * @param code {@link Integer}
     * @return {@link String}
     * @author leo
     * @date 2021/10/11
     */
    public static String getDescByCode(Integer code) {
        return of(code).map(TaskStatusCodeEnum::getDesc).orElse("");
    }

    /**
     * 功能: 根据Code 获取枚举对象.
     *
     * @param code {@link Integer}
     * @return {@link TaskStatusCodeEnum}
     * @author leo
     * @date 2021/10/11
     */
    public static TaskStatusCodeEnum getEnumByCode(Integer code) {
        return of(code).orElse(null);
    }

    /**
     * 功能: Optional 转换.
     *
     * @param code {@link Integer}
     * @return {@link Optional < TaskStatusCodeEnum >}
     * @author leo
     * @date 2021/10/11
     */
    private static Optional<TaskStatusCodeEnum> of(Integer code) {
        return Optional.ofNullable(map.get(code));
    }

}
