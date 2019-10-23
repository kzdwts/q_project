package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 乘法口诀表
 * @author: kangyong
 * @date: 2019/10/23 15:31
 * @version: v1.0
 */
public class Demo16NineXNine {

    public static void main(String[] args) {
        // i 控制行
        for (int i = 1; i < 10; i++) {
            // j 控制列
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
