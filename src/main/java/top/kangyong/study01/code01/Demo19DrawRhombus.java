package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 画菱形
 * @author: kangyong
 * @date: 2019/11/1 17:52
 * @version: v1.0
 */
public class Demo19DrawRhombus {

    public static void main(String[] args) {
//   *              1-4
//  ***             2-345
// *****            3-23456
//*******           4-1234567
// *****            5-23456
//  ***             6-345
//   *              7-4

        int h = 7;
        int w = 7;
        for (int i = 0; i < (h + 1) / 2; i++) {

            for (int j = 0; j < w / 2 - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k < (i + 1) * 2; k++) {
                System.out.print('*');
            }

            System.out.println();
        }

        for (int i = 1; i <= h / 2; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= w - 2 * i; k++) {
                System.out.print('*');
            }

            System.out.println();
        }

    }


}

