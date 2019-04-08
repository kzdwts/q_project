package test01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kangyong
 * Date: 2019/3/15 16:20
 */
public class TestFinal {

    public static void main(String[] args) {
        int result = getValue();
        System.out.println(result);
    }

    public static int getValue() {
        try {
            int n = 1 / 0;
            return 1;

        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
