package util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/11/8 16:47
 * @version: v1.0
 */
public class SplitStringUtils {

    /**
     * 手机号脱敏
     * @param phone
     * @return
     */
    public static String phoneHide(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 身份证号脱敏
     * @param idCard
     * @return
     */
    public static String idCardHide(String idCard) {
        return idCard.replaceAll("(\\d{4})\\d{10}(\\d{4})", "$1****$2");
    }

    public static void main(String[] args) {
        String phone = "17755242819";
        System.out.println(phoneHide(phone));

        String idCard = "340121200010014569";
        System.out.println(idCardHide(idCard));
    }

}
