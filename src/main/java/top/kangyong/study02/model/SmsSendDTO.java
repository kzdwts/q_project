package top.kangyong.study02.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * 测试对象转json字符串问题
 *
 * @author Kang Yong
 * @date 2022/2/25
 * @since 1.0.0
 */
@Data
@ToString
public class SmsSendDTO {

    /**
     * 手机号
     */
    private String mobilePhoneNum;

    /**
     * 短信模板标识
     */
    private String templateUuid;

    /**
     * 短信模板中需要替换的参数
     */
    private Map<String, String> param;

    private String name;

}
