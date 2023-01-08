package top.kangyong.study01.code01;

/**
 * 排序
 *
 * @author Kang Yong
 * @date 2023/1/8
 * @since 1.0.0
 */
public class Demo28Sort {

    public static void main(String[] args) {
        // 对10个数进行排序
        int num[] = new int[]{1, 9, 2, 3, 8, 5, 6, 4};

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

}
