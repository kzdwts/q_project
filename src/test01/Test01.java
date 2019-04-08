package test01;

/**
 * Created with IntelliJ IDEA.
 * Description: 循环和try-catch的嵌套
 * User: kangyong
 * Date: 2018/12/20 17:11
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        t1.test1();
        System.out.println("------------------------");
        t1.test2();
    }

    /**
     * 循环里面放try-catch
     */
    public void test1() {
        for (int i = 0; i < 9; i++) {
            try {
                int x;
                if (i == 3) {
                    x = 1 / 0;
                } else {
                    x = i;
                    System.out.println("x=" + x);
                }
            } catch (Exception e) {
                System.out.println("异常");
            }
        }
    }

    /**
     * try-catch里面放循环
     */
    public void test2() {
        try {
            for (int i = 0; i < 9; i++) {
                int x;
                if (i == 3) {
                    x = 1/0;
                }else {
                    x = i;
                    System.out.println("x==" + x);
                }
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}
